package shoesShop.common.Product;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	public Product(String name, Double price, String sku, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.name = name;
		this.price = price;
		this.sku = sku;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

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
	public Integer brandId;
	@NotNull
	public Integer categoryId;
}
