package shoesShop.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.converter.RoleConverter;
import shoesShop.entity.DbRole;
import shoesShop.model.Role;
import shoesShop.repository.IRoleRepository;

@Service
public class RoleService {
	@Autowired
	private IRoleRepository roleRepo;

	RoleConverter converter = new RoleConverter();

	public Collection<Role> retrieveAll() {
		Collection<Role> roles = this.roleRepo.findAll().stream().map(dbRole -> this.converter.convertDbToModel(dbRole))
				.collect(Collectors.toList());
		return roles;
	}

	public Role retrieveOne(Integer id) {
		Role role = this.roleRepo.findById(id).map(dbRole -> this.converter.convertDbToModel(dbRole)).orElse(null);
		return role;
	}

	public Role create(Role role) {
		DbRole dbRole = this.converter.convertModelToDb(role);
		DbRole createdRole = this.roleRepo.save(dbRole);
		return this.converter.convertDbToModel(createdRole);
	}

	public Role update(Role role, Integer id) {
		DbRole updateRole = this.converter.convertModelToDb(role);

		DbRole dbRole = this.roleRepo.findById(id).orElse(null);
		if (dbRole != null) {
			this.converter.combine(dbRole, updateRole);
			DbRole updateDbRole = this.roleRepo.save(dbRole);
			return this.converter.convertDbToModel(updateDbRole);
		}

		return null;
	}

	public Boolean delete(Integer id) {
		if (this.roleRepo.existsById(id)) {
			this.roleRepo.deleteById(id);
			return true;
		}

		return false;
	}
}
