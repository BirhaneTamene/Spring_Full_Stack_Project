package edu.mum.main;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import edu.mum.publisher.OrderPublisher;

public class Main {

	@SuppressWarnings({ "resource" })
	public static void main(String[] args) {

		ApplicationContext context = new GenericXmlApplicationContext(
				"classpath:META-INF/spring/integration/order-report-context.xml");
		
		RabbitTemplate directTemplate = context.getBean("directTemplate", RabbitTemplate.class);
		OrderPublisher directService = new OrderPublisher();
		directService.publish(directTemplate);
		
	}

}
