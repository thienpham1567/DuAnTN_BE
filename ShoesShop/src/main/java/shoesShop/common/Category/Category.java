package shoesShop.common.Category;

public class Category {
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
	public Integer categoryId;
}
