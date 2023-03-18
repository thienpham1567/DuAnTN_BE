package shoesShop.payload;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Getter;
import shoesShop.entity.DbRole;

@Getter
@AllArgsConstructor
public class UserLoginDTO {
	private String username;
	private String password;
	private String firstName;
	private Collection<DbRole> roles;
}
