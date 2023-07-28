package shoesShop.common.OrderLine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Cart.Cart;
import shoesShop.common.Order.Order;
import shoesShop.common.ProductVariationSizes.ProductVariationSize;

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
	// Ids
	public Integer orderLineId;
	
	//public Order order;
	//public ProductVariationSize productVariationSize;
}
