package shoesShop.model;

import java.util.ArrayList;
import java.util.Collection;

public class Category {
	// Properties
	public String description;
	public String code;
	
	// Ids
	private Integer categoryId;

	// Collections
	Collection<Integer> productIds = new ArrayList();	
}
