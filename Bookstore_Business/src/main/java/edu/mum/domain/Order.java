package edu.mum.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "Order_ID")
    private Long id = null;
	
	//@JoinColumn(name = "customer_id")
	@ManyToOne(fetch = FetchType.EAGER) //, cascade = CascadeType.ALL)
	private Customer customer;
	
	//@ManyToMany(mappedBy = "orders")
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinTable(name = "Order_Product",
		joinColumns = {@JoinColumn(name="Order_ID")},
		inverseJoinColumns = {@JoinColumn(name="Product_ID")})
	private List<Product> products = new ArrayList<>();

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void addProduct(Product product) {
		this.products.add(product);
	}

	@Override
	public String toString() {
		return "Order [\nProducts: \n" + products + "]";
	}

	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public void setId(long id) {
		// TODO Auto-generated method stub
		this.id = id;
		
	}
	
	
	
	
}
