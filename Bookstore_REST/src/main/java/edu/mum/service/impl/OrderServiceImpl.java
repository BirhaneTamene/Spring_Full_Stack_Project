package edu.mum.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.dao.OrderDao;
import edu.mum.dao.ProductDao;
import edu.mum.domain.Customer;
import edu.mum.domain.Order;
import edu.mum.service.OrderService;
import edu.mum.service.ProductService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private ProductService productService;
	
//	@PreAuthorize("hasRole('ROLE_USER')")
//	public void saveFull(Order order) {  
//		productService.saveAll(order.getProducts());
//		orderDao.save(order);
//  	}
	
	@Override
//	@PreAuthorize("hasRole('ROLE_USER')")
	public void save(Order order) {
		orderDao.save(order);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Order update(Order order) {
		return orderDao.update(order);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Order> findAll() {
		return orderDao.findAll();
	}
	
	@Override
	@PreAuthorize("hasRole('ROLE_USER')")
	public List<Order> findCustomerOrders(Long customerId) {
		return orderDao.findCustomerOrders(customerId); 
	}

}
