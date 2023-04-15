package shoesShop.myWebConfig;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import shoesShop.common.Role.DbRole;
import shoesShop.common.Role.IRoleRepository;
import shoesShop.common.Role.Role;
import shoesShop.common.Role.RoleConverter;
import shoesShop.common.User.CustomUserDetails;
import shoesShop.common.User.IUserRepository;
import shoesShop.common.User.User;
import shoesShop.common.User.UserConverter;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private IUserRepository userRepo;
	UserConverter userConverter = new UserConverter();
	RoleConverter roleConverter = new RoleConverter();
	@Autowired
	private IRoleRepository roleRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userConverter.convertDbToModel(userRepo.findByEmailAddress(username));
		if (user == null) {
			throw new UsernameNotFoundException("User not found with email: " + username);
		}
		Integer userId = user.getUserId();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
//		if (userId == null) {
//		    throw new UsernameNotFoundException("User ID not found for email: " + username);
//		}
		List<Role> roles = getRolesByUserId(userId);
		return new CustomUserDetails(user, roles);
	}

	private List<Role> getRolesByUserId(int userId) {
		List<Role> roles = new ArrayList<>();
		List<DbRole> dbRoles = roleRepo.findRoleByUserId(userId);
		if (dbRoles != null) {
			roles = dbRoles.stream().map(dbRole -> roleConverter.convertDbToModel(dbRole)).collect(Collectors.toList());
		}
		return roles;
	}

	private static class UserMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User(
			rs.getString("Password"),
			rs.getString("FirstName"),
			rs.getString("LastName"),
			rs.getString("EmailAddress"));
			return user;
		}
	}

	private static class RoleMapper implements RowMapper<Role> {
		@Override
		public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
			Role role = new Role(
			rs.getString("Description"),
			rs.getString("Code"),
			rs.getInt("RoleId"));
			return role;
		}
	}
}
