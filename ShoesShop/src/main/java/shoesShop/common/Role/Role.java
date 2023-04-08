package shoesShop.common.Role;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import shoesShop.common.User.DbUser;

public class Role {
	public Role() {
	}
	
	public Role(Integer roleId, String description, String code) {
		super();
		this.roleId = roleId;
		this.description = description;
		this.code = code;
	}
	
	
	// Properties
	@NotEmpty
	public String description;
	@NotEmpty
	public String code;
	
	// Ids
	private Integer roleId;
	
	// Collections
	Collection<Integer> userIds = new ArrayList();
}
