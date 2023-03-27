package shoesShop.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.NotEmpty;

import shoesShop.entity.DbProduct;

public class Brand {
	
	public Brand() {
		super();
	}

	public Brand(String name, Integer brandId) {
		super();
		this.name = name;
		this.brandId = brandId;
	}

	// Properties
	@NotEmpty
	public String name;
	
	// Ids
	private Integer brandId;
	
	// Collections
	Collection<Integer> productIds = new ArrayList<>();
}
