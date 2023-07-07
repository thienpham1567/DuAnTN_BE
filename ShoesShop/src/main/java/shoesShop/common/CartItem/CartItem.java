package shoesShop.common.CartItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Color.Color;
import shoesShop.common.Product.Product;
import shoesShop.common.ProductVariationSizes.ProductVariationSize;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	public CartItem(String cartId, Double price, Integer quantity, Product product,
			Color color, ProductVariationSize pvs) {
		this.cartId = cartId;
		this.price = price;
		this.quantity = quantity;
		this.product = product;
		this.color = color;
		this.productVariationSize = pvs;
	}
	
	public Integer cartItemId;
	public String cartId;
	
	public Double price;
	public Integer quantity;
	public String imageUrl;
	
	public Product product;
	public Color color;
	public ProductVariationSize productVariationSize;
	
}
