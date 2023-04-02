package shoesShop.service;

import java.util.Collection;

import shoesShop.model.OrderDetail;
import shoesShop.model.Product;

public interface ICartService {
	void add(Integer quantity, Product entity);
	void remove(Integer productId);
	void update(Integer productId, Integer quantity);
	void clear();
	Collection<OrderDetail> getOrder();
	Integer getTotalQuantity();
	Double getTotalAmount();
}
