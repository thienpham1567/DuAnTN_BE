package shoesShop.common.UserRole;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;

public class UserRoleConverter implements ICombiner<DbUserRole>, IConverter<DbUserRole, UserRole> {

	@Override
	public DbUserRole convertModelToDb(UserRole input) {
		return input == null ? null : new DbUserRole(input.roleId, input.userId);
	}

	@Override
	public UserRole convertDbToModel(DbUserRole input) {
		// TODO Auto-generated method stub
		return input == null ? null
				: new UserRole(input.userRoleId,

						input.user.userId, input.role.roleId

				);
	}

	@Override
	public void combine(DbUserRole original, DbUserRole update) {

//		original.userRoleId = update.userRoleId;
//		original.user.userId = update.user.userId;
//		original.role.roleId = update.role.roleId;

	}

}
