package shoesShop.common.User;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.OneToMany;

import shoesShop.common.Order.DbOrder;

public class User {
	// Properties
	public String password;
	public String firstName;
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
