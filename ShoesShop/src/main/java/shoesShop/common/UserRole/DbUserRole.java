package shoesShop.common.UserRole;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Role.DbRole;
import shoesShop.common.User.DbUser;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserRoles")
public class DbUserRole {
	
	public DbUserRole(Integer userRoleId, DbUser user, DbRole role) {
		this.userRoleId = userRoleId;
		this.user = user;
		this.role = role;
	}

	public DbUserRole(Integer roleId, Integer userId) {
		// TODO Auto-generated constructor stub
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	Integer userRoleId;

	// ok
	@ManyToOne
	@JoinColumn(name = "UserId") 
	public DbUser user;

	// ok
	@ManyToOne
	@JoinColumn(name = "RoleId") 
	public DbRole role;
	
	// done
}
