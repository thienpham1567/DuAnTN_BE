package shoesShop.common.CartItem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
	public CartItem(Integer productItemId, Integer quantity, String cartId) {
		this.productItemId = productItemId;
		this.quantity = quantity;
		this.cartId = cartId;
	}
	public Integer cartItemId;
	
	public Double price;
	public Integer quantity;
	
	public Integer productItemId;
	
	public String cartId;
}
