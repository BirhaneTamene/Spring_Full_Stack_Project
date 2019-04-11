package edu.mum.service;

import java.util.List;

import edu.mum.domain.Product;
 
public interface ProductService {

	public void saveAll(List<Product> Item);
	public void save(Product Item);
	public Product update(Product Item);
	public List<Product> findAll();
 
	public Product findOne(Long id);

}
