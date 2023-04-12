package shoesShop.common.User;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.OneToMany;

import shoesShop.common.Order.DbOrder;

public class User {
	
	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public User(String password,Integer userId, String firstName, String lastName, String email) {
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userId = userId;
	}
	public User(String password, String firstName, String middleName, String lastName, String email, String userAddress,
			Boolean isActive, Integer userId) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.email = email;
		this.userAddress = userAddress;
		this.isActive = isActive;
		this.userId = userId;
	}
	public User() {
		super();
	}
	public User(String password, String firstName, String lastName, String email) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	
}
