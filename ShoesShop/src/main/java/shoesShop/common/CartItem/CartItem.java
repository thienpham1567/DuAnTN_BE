package shoesShop.common.CartItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Color.Color;
import shoesShop.common.ProductVariationSizes.ProductVariationSize;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	public CartItem(String cartId, Double price, Integer quantity, ProductVariationSize pvs, Color color) {
		this.cartId = cartId;
		this.price = price;
		this.quantity = quantity;
		this.productVariationSize = pvs;
		this.color = color;
	}
	
	public Integer cartItemId;
	public String cartId;
	
	public Double price;
	public Integer quantity;
	public String imageUrl;
	
	public ProductVariationSize productVariationSize;
	public Color color;
}
