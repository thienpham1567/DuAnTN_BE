package shoesShop.common.Role;


import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.User.DbUser;
import shoesShop.common.UserRole.DbUserRole;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Roles")
public class DbRole {
	public DbRole(String description, String code) {
		super();
		this.description = description;
		this.code = code;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer roleId;
	
	public String description;
	public String code;
	
	// ok
	@OneToMany(mappedBy = "role") 
	Collection<DbUserRole> userRoles = new ArrayList<>();
	
	// done
}
