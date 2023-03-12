package shoesShop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	public String password;
	public String middleName;
	public String lastName;
	public String email;
	public String userAddress;
	public boolean isActive;
	
	@OneToMany(mappedBy = "user")
	List<Order> orders = new ArrayList();
	
	@OneToMany(mappedBy = "user")
	List<User> roles = new ArrayList();
}	
	