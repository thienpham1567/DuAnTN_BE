package shoesShop.model;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import shoesShop.entity.DbRole;
import shoesShop.entity.DbUser;

public class UserRole {
	// Ids
	private Integer userRoleId;	
	public Integer userId;
	public Integer roleId;
}
