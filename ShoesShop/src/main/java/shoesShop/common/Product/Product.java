package shoesShop.common.Product;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Brand.Brand;
import shoesShop.common.Category.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	// Properties
	@NotEmpty
	public String name;
	public Double price;
	public String sku;
	@NotEmpty
	public String description;
	public LocalDateTime createdAt;
	public LocalDateTime updatedAt;

	// Ids
	public Integer productId;
	@NotNull
	public Brand brand;
	@NotNull
	public Category category;
}
