package shoesShop.common.Role;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;

public class RoleConverter implements ICombiner<DbRole>, IConverter<DbRole, Role> {
	@Override
	public void combine(DbRole original, DbRole update) {
		original.description = update.description;
		original.code = update.code;
	}

	@Override
	public DbRole convertModelToDb(Role input) {
		return input == null ? null : new DbRole(input.code, input.description);
	}

	@Override
	public Role convertDbToModel(DbRole input) {
		return input == null ? null : new Role(input.code, input.description, input.roleId);
	}
}
