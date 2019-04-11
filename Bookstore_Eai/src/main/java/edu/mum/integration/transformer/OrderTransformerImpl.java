 
package edu.mum.integration.transformer;

import org.springframework.integration.annotation.Transformer;

import edu.mum.domain.Order;

/**
 * Routes order based on order type.
 * 
 */
public class OrderTransformerImpl implements OrderTransformer {

     /**
     * Transform Order from AMQP to RouteOrder for JMS
      */
	@Transformer(inputChannel="fromAmqpOrder", outputChannel="processOrder")
	public Order transformOrder(Order order) {
		return order;
	}

}
