package shoesShop.common.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	public Category(String name, Integer categoryId) {
		this.name = name;
		this.categoryId = categoryId;
	}

	public Category(String name) {
		this.name = name;
	}

	public Category(String name, Integer categoryId, String code, Category category ) {
		this.name = name;
		this.categoryId = categoryId;
		this.code = code;
		this.parentCategory = category;
	}

	// Properties
	public String name;
	public String code;
	// Ids
	public Integer categoryId;
	public Integer parentCategoryId;
	public Category parentCategory;
}
