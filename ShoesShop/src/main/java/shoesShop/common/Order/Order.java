package shoesShop.common.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	
	public Order(String denormalizedAddress, Double orderTotalPrice,
			String ordersStatus, String orderAddress,  String orderStatus, LocalDateTime updatedAt) {
		this.denormalizedAddress = denormalizedAddress;
		this.orderTotalPrice = orderTotalPrice;
		this.ordersStatus = ordersStatus;
		this.orderAddress = orderAddress;
		this.orderStatus = orderStatus;
	}

	// Properties
	@NotEmpty
	public String denormalizedAddress;
	@NotEmpty
	public Double orderTotalPrice;
	@NotEmpty
	public String ordersStatus;
	@NotEmpty
	public String orderAddress;
	@NotEmpty
	public String orderStatus;
	
	// Ids
	public String orderId;
	@NotNull
	public Integer userId;

}
