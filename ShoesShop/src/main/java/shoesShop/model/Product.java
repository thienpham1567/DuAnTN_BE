package shoesShop.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class Product {
	// Properties
	public String name;
	public String imageLink;
	public double price;
	public int inStock;
	public LocalDateTime created;
	public boolean isAvailable;
	
	// Ids
	public int productId;
	public int brandId;
	public int categoryId;
	
	// Collections
	Collection<Integer> orderDetailIds = new ArrayList();
}
