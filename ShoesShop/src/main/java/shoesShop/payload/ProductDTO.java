package shoesShop.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProductDTO {
	private String name;
	private String imageLink;
	private double price;
	private int inStock;
	private boolean isAvailabel;
	private int brand;
	private int category;
}
