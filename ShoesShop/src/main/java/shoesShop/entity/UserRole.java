package shoesShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "UserRoles")
public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userRoleId;
	
	@ManyToOne
	@JoinColumn(name = "UserId", referencedColumnName = "UserId")
	public User user;
	
	@ManyToOne
	@JoinColumn(name = "RoleId", referencedColumnName = "RoleId")
	public Role role;
}
