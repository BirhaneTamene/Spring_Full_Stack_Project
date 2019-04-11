package edu.mum.dao;

import edu.mum.domain.Customer;

public interface CustomerDao extends GenericDao<Customer> {
      
	public Customer findByEmail(String email);
	
	public Customer findByUsername(String username);
}
