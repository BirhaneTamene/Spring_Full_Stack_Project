 
package edu.mum.integration.transformer;

import edu.mum.domain.Order;

/**
 * Routes order based on order type.
 * 
 */

public interface OrderTransformer {

	public Order transformOrder(Order order);

}
