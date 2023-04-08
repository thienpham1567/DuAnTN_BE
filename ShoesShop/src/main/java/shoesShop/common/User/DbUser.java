  package shoesShop.common.User;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Order.DbOrder;
import shoesShop.common.UserRole.DbUserRole;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class DbUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer userId;
	
	public String password;
	public String firstName;
	public String lastName;
	public String emailAddress;
	public String phoneNumber;
	
	@OneToMany(mappedBy = "user")
	Collection<DbOrder> orders = new ArrayList<DbOrder>();
	
	@OneToMany(mappedBy = "user")
	Collection<DbUserRole> userRoles = new ArrayList<>();
}	
	