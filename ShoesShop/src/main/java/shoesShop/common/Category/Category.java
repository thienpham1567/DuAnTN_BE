package shoesShop.common.Category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	// Properties
	public String name;
	
	// Ids
	public Integer categoryId;
	public Integer parentCategoryId;
}
