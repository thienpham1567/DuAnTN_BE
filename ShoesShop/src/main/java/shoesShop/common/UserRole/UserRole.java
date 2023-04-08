package shoesShop.common.UserRole;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import shoesShop.common.Role.DbRole;
import shoesShop.common.User.DbUser;

public class UserRole {
	// Ids
	private Integer userRoleId;	
	public Integer userId;
	public Integer roleId;
}
