package edu.mum.main;


import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import edu.mum.domain.Address;
import edu.mum.domain.Authority;
import edu.mum.domain.Group;
import edu.mum.domain.Order;
import edu.mum.domain.Product;
import edu.mum.domain.Customer;
import edu.mum.domain.UserCredentials;
import edu.mum.security.AuthenticateCustomer;
import edu.mum.service.CustomerService;
import edu.mum.service.UserCredentialsService;
import edu.mum.service.GroupService;
import edu.mum.service.OrderService;

 
public class Main {
  public static void main(String[] args) {

    ApplicationContext ctx = new ClassPathXmlApplicationContext("context/applicationContext.xml");

    AuthenticationManager authenticationManager = (AuthenticationManager) ctx.getBean("authenticationManager");

    CustomerService customerService = (CustomerService) ctx.getBean("customerServiceImpl");
    GroupService groupService = (GroupService) ctx.getBean("groupServiceImpl");
    UserCredentialsService credentialsService = (UserCredentialsService) ctx.getBean("userCredentialsServiceImpl");
    OrderService orderService = (OrderService) ctx.getBean("orderServiceImpl");
    //UserDetailsService userDetailsService = (UserDetailsService) ctx.getBean("userDetailsServiceImpl");
    
    Authority authority = new Authority();
    authority.setAuthority("ROLE_USER");
     
    Group groupUser = new Group();
    groupUser.setGroup_name("USER");
    groupUser.getAuthority().add(authority);

    // Create ADMIN group ADD ROLE_ADMIN [ will assume ROLE_USER because of hierarchy ]
    Group groupAdmin = new Group();
    groupAdmin.setGroup_name("ADMIN");
 
   authority = new Authority();
   authority.setAuthority("ROLE_ADMIN");
   groupAdmin.getAuthority().add(authority); 


    UserCredentials userCredentials = new UserCredentials();
    userCredentials.setUserName("Sean");
    userCredentials.setPassword("Sean");
    userCredentials.setEnabled(true);
 
    // Add Sean's credentials to user group
    groupUser.getUserCredentials().add(userCredentials);
 
    Customer customer = new Customer();
    customer.setFirstName("Sean");
    customer.setLastName("Smith");

    // Link Sean's credentials to his customer
    customer.setUserCredentials(userCredentials);
    
    
    Address address =  new Address();
    address.setCity("Batavia");
    address.setState("Iowa");
  
    Address  address2 =  new Address();
    address2.setCity("Red Rock");
    address2.setState("Iowa");
          
    customer.addAddress(address);
    customer.addAddress(address2);

    // save Sean & credentials
    customerService.saveFull(customer);

    
    // THIS IS BILL--admin

    userCredentials = new UserCredentials();
    userCredentials.setUserName("Bill");
    userCredentials.setPassword("Bill");
    userCredentials.setEnabled(true);
 
    groupAdmin.getUserCredentials().add(userCredentials);
    
     customer = new Customer();
    customer.setFirstName("Bill");
    customer.setLastName("Due");

    customer.setUserCredentials(userCredentials);
    
    Address address3 =  new Address();
    address3.setCity("Washington");
    address3.setState("Iowa");
 
    Address address4 =  new Address();
    address4.setCity("Mexico");
    address4.setState("Iowa");

    customer.addAddress(address3);
    customer.addAddress(address4);
     
     customerService.saveFull(customer);
  
     // THIS is PETE--user
     
    userCredentials = new UserCredentials();
    userCredentials.setUserName("Pete");
    userCredentials.setPassword("Pete");
    userCredentials.setEnabled(true);
 
    groupUser.getUserCredentials().add(userCredentials);
    
    
    customer = new Customer();
    customer.setFirstName("Pete");
    customer.setLastName("Moss");

    customer.setUserCredentials(userCredentials);
    
    customerService.saveFull(customer);
    
    
 // THIS is BIRE--admin
    
    userCredentials = new UserCredentials();
    userCredentials.setUserName("Bire");
    userCredentials.setPassword("Bire");
    userCredentials.setEnabled(true);
 
    groupAdmin.getUserCredentials().add(userCredentials);
    
    
    customer = new Customer();
    customer.setFirstName("Bire");
    customer.setLastName("Tamene");

    customer.setUserCredentials(userCredentials);
    
    customerService.saveFull(customer);
    
    
// THIS is UJJWOL--user
    
    userCredentials = new UserCredentials();
    userCredentials.setUserName("Ujjwol");
    userCredentials.setPassword("Ujjwol");
    userCredentials.setEnabled(true);
 
    groupUser.getUserCredentials().add(userCredentials);
    
    customer = new Customer();
    customer.setFirstName("Ujjwol");
    customer.setLastName("Bhandari");

    customer.setUserCredentials(userCredentials);
    
    customerService.saveFull(customer);
    
    //save the groups
    groupService.save(groupAdmin);
    groupService.save(groupUser);
    
    //add new orders
    Product book = new Product();
    book.setName("Intro to EA");
    book.setDescription("Spring, AOP, Hibernate, REST... ");
    book.setPrice(new BigDecimal(150));
    
    Order order = new Order();
    order.addProduct(book);
    
    book = new Product();
    book.setName("Intro to Hibernate");
    book.setDescription("Hibernate... ");
    book.setPrice(new BigDecimal(250));
    
    order.addProduct(book);
    order.setCustomer(customer);
    
//    orderService.saveFull(order);
    orderService.save(order);
    customerService.update(customer);
    
//    Customer cust = customerService.findById(5l);
//    System.out.println(cust.getOrders());
    
    
     try {
    	 List<Customer> customers = customerService.findAll();
     }
     catch (AuthenticationCredentialsNotFoundException e) {
    	 System.out.println( );
    	 System.out.println( " ******** ANONYMOUS USER Attempted to access a secure resource \nPlease Log in first !! *********\n"  );
       	 System.out.println( );
     }
 
	 while (true)  {    
	     AuthenticateCustomer authenticateUser = new AuthenticateCustomer();
	     
	     try {
	  		authenticateUser.authenticate(authenticationManager);
	  		
	  	 } 
	     catch (Exception e) {
	  		e.printStackTrace();
	  	 }
	     
	//     authenticateUser.logout();
	     
	  // ANYBODY but Bill will get access Denied - AS Bill is An ADMIN & 
	  // findAll requires Admin
	     
	    
	     try {
	    	 List<Customer> customers = customerService.findAll();
	    	 
	    	 System.out.println("****** You have the aurthorization to view this. List of all customers: ******* \n");
	    	 
	    	 for (Customer customere : customers) {
	    		   
	    		   System.out.println( );
	    		   System.out.println("Customer Name : " + customere.getFirstName() + "  " +  customere.getLastName() );
	    		
	    		   for (Address addresse : customere.getAddresses()) {
	    		       System.out.println("Address : " + addresse.getCity() + 
	    						"   " + addresse.getState());
	    		   }
	    	   }
	     }
	     catch ( AccessDeniedException e) {
	 		   System.out.println( );
	 		   System.out.println("****** ACCESS DENIED ! You Need ROLE_ADMIN to access Customer findAll()  **********");
			   System.out.println( );
	
	     }
	     
	     try {
	     
		     Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	    	 String currentPrincipalName = authentication.getName();
	    	 
	    	 System.out.println("\n****** Currently logged in user: ******* \n" + currentPrincipalName);
	    	 
	    	 Long custId = customerService.findByUsername(currentPrincipalName).getId();
	    	 
	    	 //System.out.println("Id of the customer: " + custId);
	    	 
	    	 List<Order> orders = orderService.findCustomerOrders(custId);
	    	 
	    	 System.out.println("\n***** Your orders: *****\n" + orders);
	    	 
	    	 //CHeck if user has access to all orders or not
	    	 System.out.println("***** Orders from all users: *****\n" + orders);
	    	 orders = orderService.findAll();
	    	 
	     }
	     catch (AccessDeniedException e) {
	    	   System.out.println( );
	 		   System.out.println("****** ACCESS DENIED ! You Need ROLE_ADMIN to access Order findAll()  **********");
			   System.out.println( );
	     }
	      
	   }
  	} 
  }