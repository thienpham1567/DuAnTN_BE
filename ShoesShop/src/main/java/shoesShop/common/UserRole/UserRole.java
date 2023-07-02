package shoesShop.common.UserRole;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Role.DbRole;
import shoesShop.common.Role.Role;
import shoesShop.common.User.DbUser;
import shoesShop.common.User.User;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRole {
	// Ids
	Integer userRoleId;	
	Integer userId;
	Integer roleId;
	
	User user;
	Role role;
	public UserRole(Integer userRoleId, User user, Role role , Integer roleId) {
		super();
		this.userRoleId = userRoleId;
		this.user = user;
		this.role = role;
		this.roleId = roleId;
	}
	
	
}
