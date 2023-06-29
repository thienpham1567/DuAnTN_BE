package shoesShop.common.Cart;

import shoesShop.common.Product.Product;

public interface ICartService {
	Cart add(String cartId, Integer quantity, Product entity);
	Cart remove(String cartId, Integer cartItemId);
	Cart update(String cartId, Integer cartItemId, Integer quantity);
	Cart clear();
	Integer getTotalQuantity(String cartId);
	Double getSubTotalPrice(String cartId);
}
