package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.GenericDao;
import edu.mum.dao.CustomerDao;
import edu.mum.domain.Customer;
import edu.mum.service.UserCredentialsService;

@Service
@Transactional 
public class CustomerServiceImpl implements edu.mum.service.CustomerService {
	
 	@Autowired
	private CustomerDao customerDao;

 	@Autowired
 	UserCredentialsService credentialsService;
 	
 	public void saveFull( Customer customer) {  		
  		credentialsService.save(customer.getUserCredentials());
  		customerDao.save(customer);
  	}
 	
     public void save( Customer user) {  		
    	 customerDao.save(user);
 	}
  	
     @PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Customer> findAll() {
		return (List<Customer>)customerDao.findAll();
	}

	public Customer findByEmail(String email) {
		return customerDao.findByEmail(email);
	}
	
	public Customer findByUsername(String username) {
		return customerDao.findByUsername(username);
	}
	
	public Customer update(Customer user) {
		 return customerDao.update(user);

	}

 	public Customer testRefresh(Customer user) {
		user.setEmail("Lotta@Doe.com");
		customerDao.save(user);
		
		  return user;
	}

	@Override
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Customer findById(Long id) {
		Customer cust = customerDao.findOne(id);
		cust.getOrders().get(0).getProducts().get(0);
		return cust;
	}
	
	public Customer findOneFull(Long id) {
		Customer customer = this.findById(id);
		
// OR 		"SELECT p FROM Customer m JOIN FETCH m.userCredentials WHERE m.id = (:id)"
		customer.getUserCredentials();
		
		return  customer;
	}
 

}
