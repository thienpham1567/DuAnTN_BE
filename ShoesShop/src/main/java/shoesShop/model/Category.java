package shoesShop.model;

import java.util.ArrayList;
import java.util.Collection;

public class Category {
	
	
	public Category() {
		super();
	}
	

	public Category(String description, String code, Integer categoryId) {
		super();
		this.description = description;
		this.code = code;
		this.categoryId = categoryId;
	}


	// Properties
	public String description;
	public String code;
	
	// Ids
	private Integer categoryId;

	// Collections
	Collection<Integer> productIds = new ArrayList();	
}
