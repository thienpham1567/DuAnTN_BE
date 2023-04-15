package shoesShop.common.UserRole;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.Role.IRoleRepository;
import shoesShop.common.User.IUserRepository;

@Service
public class UserRoleService extends RecordManager<UserRole>{
	@Autowired
	private IUserRoleRepository userRoleRepo;
	
	@Autowired
	private IRoleRepository roleRepo;
	
	@Autowired 
	private IUserRepository userRelo;
	
	UserRoleConverter converter = new UserRoleConverter();

	@Override
	public Collection<UserRole> retrieveAll() throws Exception {
		Collection<UserRole> userRoles = this.load(null, null, null).stream()
				.map(dbUserRole -> this.converter.convertDbToModel(dbUserRole)).collect(Collectors.toList());
		return userRoles;
	}

	@Override
	public UserRole retrieveOne(Integer id) throws Exception {
		UserRole userRole = this.load(id, null, null).stream()
				.map(dbUserRole -> this.converter.convertDbToModel(dbUserRole)).findFirst().get();
		return userRole;
	}

	@Override
	public UserRole create(UserRole userRole) throws Exception {
		DbUserRole dbUserRole = this.converter.convertModelToDb(userRole);
		dbUserRole.role = this.roleRepo.findById(userRole.roleId).get();
		dbUserRole.user = this.userRelo.findById(userRole.userId).get();
		DbUserRole createdUserRole = this.userRoleRepo.save(dbUserRole);
		return this.converter.convertDbToModel(createdUserRole);
	}

	@Override
	public UserRole update(UserRole userRole, Integer id) throws Exception {
		DbUserRole dbUserRole = this.converter.convertModelToDb(userRole);
		dbUserRole.role = this.roleRepo.findById(userRole.roleId).get();
		dbUserRole.user = this.userRelo.findById(userRole.userId).get();
		
		DbUserRole userRoleById = this.userRoleRepo.findById(id).get();
		if(userRoleById == null) {
			return null;
		}
		dbUserRole.userRoleId = id;
		DbUserRole updateDbUserRole = this.userRoleRepo.save(dbUserRole);
		return this.converter.convertDbToModel(updateDbUserRole);
		

		
	}

	@Override
	public Boolean delete(Integer id) throws Exception {
		if (this.userRoleRepo.existsById(id)) {
			this.userRoleRepo.deleteById(id);
			return true;
		}

		return false;
	}
	
	private Collection<DbUserRole> load(Integer userRoleId, Integer roleId, Integer userId) {
		Collection<DbUserRole> dbUserRoles = this.userRoleRepo.findAll();

		if (userRoleId != null) {
			dbUserRoles = dbUserRoles.stream().filter(dbUserRole -> dbUserRole.userRoleId == userRoleId)
					.collect(Collectors.toList());
		}

		if (roleId != null && userId != null) {
			return dbUserRoles = dbUserRoles.stream().filter(
					dbUserRole -> dbUserRole.role.roleId == roleId && dbUserRole.user.userId == userId)
					.collect(Collectors.toList());
		}

		if (roleId != null) {
			dbUserRoles = dbUserRoles.stream().filter(dbUserRole -> dbUserRole.role.roleId == roleId)
					.collect(Collectors.toList());
		}

		if (userId != null) {
			dbUserRoles = dbUserRoles.stream().filter(dbUserRole -> dbUserRole.user.userId == userId)
					.collect(Collectors.toList());
		}

		return dbUserRoles;
	}
}
