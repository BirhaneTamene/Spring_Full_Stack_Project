package edu.mum.integration.listener;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.mum.domain.Order;


public class OrderMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(OrderMessageListener.class);

    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        Order order = null;
		try {
			order = (Order) objectMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("Message received: " );
        System.out.println("Order : "  +  order);

    }
}
