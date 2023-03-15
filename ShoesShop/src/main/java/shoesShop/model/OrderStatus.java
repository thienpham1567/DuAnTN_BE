package shoesShop.model;

import java.util.ArrayList;
import java.util.Collection;

import shoesShop.entity.DbOrder;

public class OrderStatus {
	// Properties	
	private String description;
	
	// Ids
	private Integer orderStatusId;
	
	// Collections
	Collection<Integer> orderIds = new ArrayList();
}
