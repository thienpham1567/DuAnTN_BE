package shoesShop.common.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Address.Address;
import shoesShop.common.CartItem.CartItem;
import shoesShop.common.OrderLine.DbOrderLine;
import shoesShop.common.OrderLine.OrderLine;
//import shoesShop.common.OrderLine.OrderLine;
import shoesShop.common.User.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

	// Properties
	public Integer addressId;
	@NotEmpty
	public Double orderTotalPrice;
	@NotEmpty
	public String ordersStatus;

	public LocalDateTime createdAt;
	public LocalDateTime updatedAt;
	
	// Ids
	public String orderId;
	
	public Address address;
	public User user;
	public Collection<OrderLine> orderLines  = new ArrayList<>();
	
	public void setOrderLines(Collection<CartItem> collection) {
	    List<OrderLine> orderLines = collection.stream()
	            .map(cartItem -> new OrderLine(
	                this.orderId, // Sử dụng orderId của Order
	                cartItem.getPrice(),
	                cartItem.getQuantity(),
	                cartItem.getImageUrl(),
	                cartItem.getProductVariationSize(),
	                cartItem.getColor()
	            ))
	            .collect(Collectors.toList());
	    
	    this.orderLines = orderLines;
	}
	
	
	public void setOrderLiness(List<OrderLine> list) {
	    List<OrderLine> orderLines = list.stream()
	            .map(cartItem -> new OrderLine(
	                this.orderId, // Sử dụng orderId của Order
	                cartItem.getPrice(),
	                cartItem.getQuantity(),
	                cartItem.getImageUrl(),
	                cartItem.getProductVariationSize(),
	                cartItem.getColor()
	            ))
	            .collect(Collectors.toList());
	    
	    this.orderLines = orderLines;
	}

}
