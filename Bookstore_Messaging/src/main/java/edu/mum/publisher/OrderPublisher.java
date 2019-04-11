package edu.mum.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import edu.mum.domain.Customer;
import edu.mum.domain.Order;

public class OrderPublisher {

	public void publish(RabbitTemplate rabbitTemplate) {
		Customer customer = new Customer();
		customer.setFirstName("Birhane");
		customer.setEmail("btamene@mum.edu");
		
		Order order = new Order();
		order.setId(1l);
		order.setCustomer(customer);
		rabbitTemplate.convertAndSend(order);
		
		System.out.println(" Order Published! ID : "+order.getId());
		System.out.println("===========================================================");
		
		order.setId(2l) ;
        rabbitTemplate.convertAndSend(order);
		System.out.println(" Order Published! ID : "+order.getId());
		System.out.println("===========================================================");
	}
}
