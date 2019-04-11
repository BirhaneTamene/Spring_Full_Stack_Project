package edu.mum.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;
 

@Entity
@Table(name = "Product")
 public class Product implements Serializable {

    private static final String COLLECTION_ID_GENERATOR = "identity";

    @Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ID")
    private Long id = null;

	@Column(name = "NAME", length = 255, nullable = false, updatable = false)
    private String name;


    @Column(name = "DESCRIPTION", length = 4000, nullable = false)
    private String description;

     private BigDecimal price;

//     @ManyToMany(mappedBy = "items", 
//    		 	fetch = FetchType.EAGER, 
//    		 	cascade = {CascadeType.MERGE, CascadeType.PERSIST})
     
     @ManyToMany(mappedBy = "products", fetch = FetchType.EAGER,
		cascade = {CascadeType.MERGE, CascadeType.PERSIST})
//     @JoinTable(name = "Product_Order",
//		joinColumns = {@JoinColumn(name="Product_ID")},
//		inverseJoinColumns = {@JoinColumn(name="Order_ID")})
     private List<Order> orders = new LinkedList<Order>();

    
     public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
 
    @Transient
    private Collection<String> images = new ArrayList<String>();

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name="CREATED", nullable = false, updatable = false)
//    private Date created = new Date();

    
    /**
     * No-arg constructor for JavaBean tools.
     */
    public Product() {}

 

    // ********************** Accessor Methods ********************** //

    public Long getId() { return id; }
//    public int getVersion() { return version; }

    public String getName() { return name; }
    public void setName(String name) {this.name = name; }


    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) {this.price = price; }

    public String toString() {
        return  "\nItem ('" + getId() + "'), " +
                "\nName: '" + getName() + "' " +
                "\nPrice: '" + getPrice()+ "'";
    }
  
}
