package shoesShop.payload;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import shoesShop.entity.Role;

@Getter
@AllArgsConstructor
public class UserCreationDTO {
	private String username;
	private String password;
	private Collection<Role> roles;
}
