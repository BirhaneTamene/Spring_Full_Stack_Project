package edu.mum.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mum.domain.Customer;
import edu.mum.service.CustomerService;

@RestController
@RequestMapping({"/customers"})
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@RequestMapping(path = "", method = RequestMethod.GET, produces = "application/json")
	//@GetMapping(path = "/", produces = "application/json")
	public List<Customer> findAll( ) {
		List<Customer> customerList = customerService.findAll();
		System.out.println("#####################\n" + customerList);
		return  customerList;
 
	}
//	public String findAll( ) {
//		List<Customer> customerList = customerService.findAll();
//		System.out.println("#####################\n" + customerList);
//		return  "POTATO";
// 
//	}
	
  	@RequestMapping("/{id}")
	public Customer getCustomerById(@PathVariable("id") Long id) {
		return   customerService.findById(id);
 
	}
	   
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void processAddNewMemberForm(@RequestBody Customer customerToBeAdded) {
		customerService.save(customerToBeAdded);
 
	}
}
