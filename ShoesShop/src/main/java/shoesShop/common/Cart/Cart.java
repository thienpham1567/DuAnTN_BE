package shoesShop.common.Cart;

import java.util.ArrayList;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.CartItem.CartItem;
import shoesShop.common.User.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	public String cartId;
	
	public Integer itemTotalQuantity;
	public Double itemSubtotalPrice;
	
	public User user;
	public Collection<CartItem> cartItems = new ArrayList<>();
}
