package shoesShop.common.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Product {
	public Product() {
	}

	public Product(Integer productId, String name, String imageLink, Double price, Integer inStock, Boolean isAvailable, Integer brandId, Integer categoryId) {
		super();
		this.productId = productId;
		this.name = name;
		this.imageLink = imageLink;
		this.price = price;
		this.inStock = inStock;
		this.created = LocalDateTime.now();
		this.isAvailable = isAvailable;
		this.brandId = brandId;
		this.categoryId = categoryId;
	}

	// Properties
	@NotEmpty
	public String name;
	@NotEmpty
	public String imageLink;
	@NotNull
	@Min(0)
	public Double price;
	@NotNull
	@Min(0)
	public Integer inStock;
	
	public LocalDateTime created = LocalDateTime.now();
	public Boolean isAvailable;

	// Ids
	public Integer productId;
	@NotNull
	public Integer brandId;
	@NotNull
	public Integer categoryId;
	
	// Collections
	public Collection<Integer> orderDetailIds = new ArrayList<>();
}
