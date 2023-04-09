package shoesShop.common.ProductItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductItem {
	public Integer productItemId;
	
	public String sku;
	public Double price;
	public Integer quantityInStock;
	public String imageUrl;
	public String status;
	
	public Integer sizeId;
	public Integer colorId;
	public Integer productId;
}
