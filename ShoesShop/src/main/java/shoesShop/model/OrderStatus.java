package shoesShop.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import shoesShop.entity.DbOrder;

public class OrderStatus {
	// Properties
	private Integer orderStatusId;
	
	private String description;
	
	@OneToMany(mappedBy = "orderStatus")
	Collection<DbOrder> orders = new ArrayList();
	// Ids
	// Collections
}
