package edu.mum.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import edu.mum.dao.OrderDao;
import edu.mum.domain.Order;

@SuppressWarnings("unchecked")
@Repository
public class OrderDaoImpl extends GenericDaoImpl<Order> implements OrderDao {
	
	public OrderDaoImpl() {
		super.setDaoType(Order.class);
	}

	@Override
	public List<Order> findCustomerOrders(Long customerId) {
		
		Query query = entityManager.createQuery("select o from Order o JOIN FETCH o.customer c where c.id =:customerID");
		return (List<Order>) query.setParameter("customerID", customerId).getResultList();

	}
}
