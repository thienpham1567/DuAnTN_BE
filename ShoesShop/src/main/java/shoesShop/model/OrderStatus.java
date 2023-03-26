package shoesShop.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import shoesShop.entity.DbOrder;

public class OrderStatus {
	public OrderStatus() {
	}

	public OrderStatus(Integer orderStatusId, String description) {
		super();
		this.orderStatusId = orderStatusId;
		this.description = description;
		this.created = LocalDateTime.now();
	}
	
	// Properties	
	public String description;
	public LocalDateTime created = LocalDateTime.now();
	// Ids
	private Integer orderStatusId;
	
	// Collections
	Collection<Integer> orderIds = new ArrayList();
}
