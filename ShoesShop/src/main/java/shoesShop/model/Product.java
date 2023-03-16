package shoesShop.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class Product {
	public Product(Integer productId, String name, String imageLink, Double price, Integer inStock,
			LocalDateTime created, Boolean isAvailable, Integer brandId, Integer categoryId) {
		super();
		this.productId = productId;
		this.name = name;
		this.imageLink = imageLink;
		this.price = price;
		this.inStock = inStock;
		this.created = created;
		this.isAvailable = isAvailable;
		this.brandId = brandId;
		this.categoryId = categoryId;
	}

	// Properties
	public String name;
	public String imageLink;
	public Double price;
	public Integer inStock;
	public LocalDateTime created;
	public Boolean isAvailable;
	
	// Ids
	public Integer productId;
	public Integer brandId;
	public Integer categoryId;
	
	// Collections
	public Collection<Integer> orderDetailIds = new ArrayList();
}
