package shoesShop.common.Brand;

import javax.validation.constraints.NotEmpty;

public class Brand {
	public Brand(Integer brandId, String name) {
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
