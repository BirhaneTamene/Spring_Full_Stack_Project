package edu.mum.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import edu.mum.dao.ProductDao;
import edu.mum.domain.Product;

@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao {

	public ProductDaoImpl() {
		super.setDaoType(Product.class );
	}

 }