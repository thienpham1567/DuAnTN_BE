package shoesShop.common.User;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Order.DbOrder;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	public User(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = email;
	}
	
	public User(String password, String firstName, String lastName, String email) {
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = email;
	}
	
	public User(String password,Integer userId, String firstName, String lastName, String email) {
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = email;
		this.userId = userId;
	}
	
	// Properties
	public String password;
	public String firstName;
	public String lastName;
	public String emailAddress;
	public String phoneNumber;
	
	// Ids
	private Integer userId;
		
	// Collections
	Collection<Integer> orderIds = new ArrayList();
	Collection<Integer> roleIds = new ArrayList();
}
