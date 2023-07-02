package shoesShop.common.User;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.Product.DbProduct;
import shoesShop.common.Product.Product;
import shoesShop.common.Role.DbRole;
import shoesShop.common.UserRole.DbUserRole;
import shoesShop.common.UserRole.IUserRoleRepository;


@Service
public class UserSerivce extends RecordManager<User>{
	@Autowired
	private IUserRepository userRepo;
	
	UserConverter converter = new UserConverter();
	
	@Autowired
	private IUserRoleRepository userRoleRepo;

	@Override
	public Collection<User> retrieveAll() throws Exception {
		Collection<User> users = this.load(null).stream()
				.map(dbUser -> this.converter.convertDbToModel(dbUser)).collect(Collectors.toList());
		return users;
	}
	public User findByEmail(String email){
		User user = converter.convertDbToModel(userRepo.findByEmailAddress(email));
		return user;
	}
	@Override
	public User retrieveOne(Integer id) throws Exception {
		User user = this.load(id).stream()
				.map(dbUser -> this.converter.convertDbToModel(dbUser)).findFirst().get();
		return user;
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public User create(User user) throws Exception {
	    // Mã hóa mật khẩu trước khi lưu vào cơ sở dữ liệu
	    user.setPassword(passwordEncoder.encode(user.getPassword()));
	    
	    DbUser dbUser = this.converter.convertModelToDb(user);
	    DbUser createdUser = this.userRepo.save(dbUser);
	    DbUserRole dbUserRole = new DbUserRole();
	    dbUserRole.setUser(createdUser); // Gán createdUser cho trường user trong dbUserRole
	    dbUserRole.setRole(new DbRole()); // Khởi tạo đối tượng DbRole
	    dbUserRole.getRole().setRoleId(1);
	    DbUserRole createdUserRole = this.userRoleRepo.save(dbUserRole);
	    return this.converter.convertDbToModel(createdUser);
	}

	@Override
	public User update(User record, Integer id) throws Exception {
		// TODO Auto-generated method stub
		return super.update(record, id);
	}

	@Override
	public Boolean delete(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return super.delete(id);
	}
	
	private Collection<DbUser> load(Integer userId) {
		Collection<DbUser> dbUsers = this.userRepo.findAll();

		if (userId != null) {
			dbUsers = dbUsers.stream().filter(dbUser -> dbUser.userId == userId)
					.collect(Collectors.toList());
		}

		return dbUsers;
	}
	
}
