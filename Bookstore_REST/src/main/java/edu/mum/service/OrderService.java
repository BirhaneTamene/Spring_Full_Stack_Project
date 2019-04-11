package edu.mum.service;

import java.util.List;

import edu.mum.domain.Order;

public interface OrderService {

//	public void saveFull(Order order);
	public void save(Order order);
	public Order update(Order order);
	public List<Order> findAll();
	public List<Order> findCustomerOrders(Long customerId);
}
