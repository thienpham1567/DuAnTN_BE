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
	// Properties
	public String name;
	
	// Ids
	public Integer categoryId;
	public Category parentCategory;
}
