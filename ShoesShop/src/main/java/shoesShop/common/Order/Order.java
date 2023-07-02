package shoesShop.common.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.User.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	// Properties
	@NotEmpty
	public String denormalizedAddress;
	@NotEmpty
	public Double orderTotalPrice;
	@NotEmpty
	public String ordersStatus;

	public LocalDateTime createdAt;
	public LocalDateTime updatedAt;
	// Ids
	public String orderId;
	@NotNull
	public User user;

}
