package shoesShop.common.Role;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	// Properties
	@NotEmpty
	public String description;
	@NotEmpty
	public String code;
	
	// Ids
	public Integer roleId;
}
