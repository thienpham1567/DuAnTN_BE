package shoesShop.model;

import java.util.ArrayList;
import java.util.Collection;

import shoesShop.entity.DbProduct;

public class Brand {
	// Properties
	public String name;
	
	// Ids
	private Integer brandId;
	
	// Collections
	Collection<Integer> productIds = new ArrayList<>();
}
