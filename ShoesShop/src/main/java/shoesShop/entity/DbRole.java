package shoesShop.entity;

import java.time.LocalDateTime;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Roles")
public class DbRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer roleId;
	
	public String description;
	public String code;
	
	@OneToMany(mappedBy = "role")
	Collection<DbUserRole> userRoles = new ArrayList<DbUserRole>();
}
