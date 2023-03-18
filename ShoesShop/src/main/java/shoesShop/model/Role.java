package shoesShop.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.OneToMany;

import shoesShop.entity.DbUser;

public class Role {
	// Properties
	public String description;
	public String code;
	
	// Ids
	private Integer roleId;
	
	// Collections
	Collection<Integer> userIds = new ArrayList();
}
