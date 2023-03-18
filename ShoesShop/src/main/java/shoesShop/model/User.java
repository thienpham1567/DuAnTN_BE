package shoesShop.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.OneToMany;

import shoesShop.entity.DbOrder;
import shoesShop.entity.DbUser;

public class User {
	// Properties
	public String password;
	public String middleName;
	public String lastName;
	public String email;
	public String userAddress;
	public Boolean isActive;
	
	// Ids
	private Integer userId;
		
	// Collections
	Collection<Integer> orderIds = new ArrayList();
	Collection<Integer> roleIds = new ArrayList();
}
