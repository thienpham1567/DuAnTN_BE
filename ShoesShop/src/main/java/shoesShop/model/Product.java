package shoesShop.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

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
	@NotEmpty
	public String name;
	@NotEmpty
	public String imageLink;
	@NotEmpty
	@Min(0)
	public Double price;
	@NotEmpty
	@Min(0)
	public Integer inStock;
	public LocalDateTime created;
	public Boolean isAvailable;
	
	// Ids
	public Integer productId;
	@NotEmpty
	public Integer brandId;
	@NotEmpty
	public Integer categoryId;
	
	// Collections
	public Collection<Integer> orderDetailIds = new ArrayList();
}
