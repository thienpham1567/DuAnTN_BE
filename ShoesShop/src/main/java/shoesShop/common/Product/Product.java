package shoesShop.common.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	public Product(String name, String desciption, LocalDateTime updatedAt) {
		this.name = name;
		this.desciption = desciption;
		this.updatedAt = updatedAt;
	}

	// Properties
	@NotEmpty
	public String name;
	@NotEmpty
	public String desciption;

	public LocalDateTime createdAt = LocalDateTime.now();
	public LocalDateTime updatedAt;

	// Ids
	public Integer productId;
	@NotNull
	public Integer brandId;
	@NotNull
	public Integer categoryId;
}
