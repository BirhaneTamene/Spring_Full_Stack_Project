package edu.mum.dao;

import java.util.List;

import edu.mum.domain.Order;

public interface OrderDao extends GenericDao<Order> {

	List<Order> findCustomerOrders(Long customerId);
	
}
