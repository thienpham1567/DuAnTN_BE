package shoesShop.common.Cart;

import shoesShop.common.CartItem.CartItem;

public interface ICartService {
	Cart add(String cartId, CartItem cartItem);
	Cart remove(String cartId, Integer cartItemId);
	Cart update(String cartId, CartItem cartItem);
	Cart clear();
	Integer getTotalQuantity(String cartId);
	Double getSubTotalPrice(String cartId);
}
