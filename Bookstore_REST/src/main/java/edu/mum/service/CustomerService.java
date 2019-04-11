package edu.mum.service;

import java.util.List;

import edu.mum.domain.Customer;
 
public interface CustomerService {

	public void saveFull(Customer customer);
	public void save(Customer user);
	public List<Customer> findAll();
	public Customer findByEmail(String email);
	public Customer findById(Long id);
	public Customer update(Customer user);
	public Customer testRefresh(Customer user);
	
	public Customer findByUsername(String username);
}
