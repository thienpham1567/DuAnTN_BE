  package shoesShop.common.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Cart.DbCart;
import shoesShop.common.Favorite.DbFavorite;
import shoesShop.common.Order.DbOrder;
import shoesShop.common.Review.DbReview;
import shoesShop.common.UserAddress.DbUserAddress;
import shoesShop.common.UserRole.DbUserRole;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Users")
public class DbUser {
	public DbUser(String password, String firstName, String lastName, String emailAddress, String phoneNumber) {
		super();
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer userId;
	
	public String password;
	public String firstName;
	public String lastName;
	public String emailAddress;
	public String phoneNumber;
	
	@OneToMany(mappedBy = "user") 
	Collection<DbCart> carts = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	Collection<DbUserAddress> userAddress = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	Collection<DbOrder> orders = new ArrayList<DbOrder>();
	
	@OneToMany(mappedBy = "user")
	Collection<DbUserRole> userRoles = new ArrayList<>();
	
	@OneToMany(mappedBy = "user")
	Collection<DbReview> reviews = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	Collection<DbFavorite> favorites; 
	// done
}	
	