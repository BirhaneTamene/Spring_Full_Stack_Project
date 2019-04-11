package edu.mum.dao.impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.CustomerDao;
import edu.mum.domain.Customer;


@SuppressWarnings("unchecked")
@Repository
public class CustomerDaoImpl extends GenericDaoImpl<Customer> implements CustomerDao {

	public CustomerDaoImpl() {
		super.setDaoType(Customer.class );
	}

	public Customer findByEmail(String email) {
	     
		Query query = entityManager.createQuery("select u from Customer u  where u.email =:email");
		return (Customer) query.setParameter("email", email).getSingleResult();
	}
	
	public Customer findByUsername(String username) {
		
		Query query = entityManager.createQuery("select c from Customer c JOIN FETCH c.userCredentials uc where uc.userName =:username");
		return (Customer) query.setParameter("username", username).getSingleResult();
	}


 }