package shoesShop.common.UserRole;

import java.time.LocalDateTime;
import java.util.Collection;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserRoles")
public class DbUserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer userRoleId;
	
	@ManyToOne
	@JoinColumn(name = "UserId", referencedColumnName = "UserId")
	public DbUser user;
	
	@ManyToOne
	@JoinColumn(name = "RoleId", referencedColumnName = "RoleId")
	public DbRole role;
}
