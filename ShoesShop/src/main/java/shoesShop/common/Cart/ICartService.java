package shoesShop.common.Cart;

import java.util.Collection;

import shoesShop.common.OrderLine.OrderLine;
import shoesShop.common.Product.Product;

public interface ICartService {
	void add(Integer quantity, Product entity);
	void remove(Integer productId);
	void update(Integer productId, Integer quantity);
	void clear();
	Collection<OrderLine> getOrder();
	Integer getTotalQuantity();
	Double getTotalAmount();
}
