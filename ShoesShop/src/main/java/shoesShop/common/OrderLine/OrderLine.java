package shoesShop.common.OrderLine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Cart.Cart;
import shoesShop.common.Color.Color;
import shoesShop.common.Order.Order;
import shoesShop.common.ProductVariationSizes.ProductVariationSize;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {
	public OrderLine(String orderId, Double price, Integer quantity, ProductVariationSize pvs, Color color) {
		this.orderId = orderId;
		this.price = price;
		this.quantity = quantity;
		this.productVariationSize = pvs;
		this.color = color;
	}

	public Integer orderLineId;
	public String orderId;
	
	public Double price;
	public Integer quantity;
	public String imageUrl;

	public ProductVariationSize productVariationSize;
	public Color color;
}
