package edu.mum.listener;

import edu.mum.domain.Order;

public class OrderListener {

	public void listen(Order order) {	
			
		System.out.println(" Order Accepted : ");
		System.out.println("===========================================================");
		System.out.println("       Order Id: " + order.getId());
		System.out.println("       Ordered by: " + order.getCustomer().getFirstName());
		System.out.println("       Customer Email: " + order.getCustomer().getEmail());
		System.out.println("===========================================================");
	}
}
