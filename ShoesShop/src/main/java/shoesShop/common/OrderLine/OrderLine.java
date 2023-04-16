package shoesShop.common.OrderLine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLine {
	
	// Properties
	public Double detailPrice;
	public Integer quantity;
	
	// Ids
	public Integer orderLineId;
	private Integer orderDetailId;
	public Integer productItemId;
	public String orderId;
	public OrderLine(Double detailPrice, Integer quantity, Integer orderLineId, Integer productItemId, String orderId) {
		super();
		this.detailPrice = detailPrice;
		this.quantity = quantity;
		this.orderLineId = orderLineId;
		this.productItemId = productItemId;
		this.orderId = orderId;
	}
	
}
