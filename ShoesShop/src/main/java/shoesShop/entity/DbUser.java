package shoesShop.entity;

import java.util.ArrayList;
import java.util.Collection;

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
public class DbUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	public String password;
	public String middleName;
	public String lastName;
	public String email;
	public String userAddress;
	public Boolean isActive;
	
	@OneToMany(mappedBy = "user")
	Collection<DbOrder> orders = new ArrayList();
	
	@OneToMany(mappedBy = "user")
	Collection<DbUser> roles = new ArrayList();
}	
	