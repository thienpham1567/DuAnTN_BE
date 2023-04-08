package shoesShop.common.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

public class Order {
	// Properties
	public LocalDateTime created;
	public LocalDateTime updated;
	public String orderAddress;
	public double orderAmount;
	
	// Ids
	public int orderId;
	public int userId;
	public int orderStatusId;
	
	// Collections
	public Collection<Integer> orderDetailIds = new ArrayList();
}
