package shoesShop.common.Category;

import java.util.ArrayList;
import java.util.Collection;

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

	// Properties
	public String name;
	
	// Ids
	public Integer categoryId;
	public Category parentCategory;
}
