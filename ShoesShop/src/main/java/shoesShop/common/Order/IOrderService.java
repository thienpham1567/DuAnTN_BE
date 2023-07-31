package shoesShop.common.Order;
import shoesShop.common.OrderLine.OrderLine;

public interface IOrderService {
//	Order add(String cartId, CartItem cartItem);
//	Order remove(String cartId, Integer cartItemId);
//	Order update(String cartId, CartItem cartItem);
//	Order clear();
//	Integer getTotalQuantity(String orderId);
	Double getOrderTotalPrice(String orderId);
}
