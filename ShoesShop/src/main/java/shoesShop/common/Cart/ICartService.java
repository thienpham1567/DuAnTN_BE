package shoesShop.common.Cart;

import shoesShop.common.ProductItem.ProductItem;

public interface ICartService {
	Cart add(String cartId, Integer quantity, ProductItem entity);
	Cart remove(String cartId, Integer cartItemId);
	Cart update(String cartId, Integer cartItemId, Integer quantity);
	Cart clear();
	Integer getTotalQuantity();
	Double getSubTotalPrice();
}
