package shoesShop.common.OrderLine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Cart.Cart;
import shoesShop.common.Order.Order;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {
	public OrderLine(Double price, Integer quantity) {
		this.price = price;
		this.quantity = quantity;
	}
	// Properties
	public Double price;
	public Integer quantity;
	public String orderId;
	// Ids
	public Integer orderLineId;
}
