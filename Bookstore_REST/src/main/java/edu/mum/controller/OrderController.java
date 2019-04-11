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
import edu.mum.domain.Order;
import edu.mum.service.OrderService;

@RestController
@RequestMapping({"/orders"})
public class OrderController {
	
	@Autowired
	private OrderService orderService;

	@RequestMapping
	public List<Order> findAll( ) {
		List<Order> orderList = orderService.findAll();
		return  orderList;
 
	}
	
  	@RequestMapping("/{id}")
	public List<Order> getOrdersByCustomerId(@PathVariable("id") Long id) {
		return   orderService.findCustomerOrders(id);
 
	}
	   
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void processAddNewMemberForm(@RequestBody Order orderToBeAdded) {
		orderService.save(orderToBeAdded);
 
	}
}
