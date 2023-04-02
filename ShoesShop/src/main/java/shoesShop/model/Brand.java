package shoesShop.model;

import javax.validation.constraints.NotEmpty;

public class Brand {
	public Brand(String name, Integer brandId) {
		super();
		this.name = name;
		this.brandId = brandId;
	}

	// Properties
	@NotEmpty
	public String name;
	
	// Ids
	public Integer brandId;
}
