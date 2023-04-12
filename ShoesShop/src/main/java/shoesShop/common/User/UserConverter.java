package shoesShop.common.User;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.Product.DbProduct;

public class UserConverter implements ICombiner<DbUser>, IConverter<DbUser, User>{

	@Override
	public DbUser convertModelToDb(User input) {
		return input == null ? null : new DbUser(
				input.password,
				input.firstName,
				input.lastName,
				input.email
			);
	}

	@Override
	public User convertDbToModel(DbUser input) {
		return input == null ? null : new User(
				input.password,
				input.userId,
				input.firstName,
				input.lastName,
				input.emailAddress
			);
	}

	@Override
	public void combine(DbUser original, DbUser update) {
		original.emailAddress = update.emailAddress;
		original.firstName = update.firstName;
		original.lastName = update.lastName;
		
		
	}

}
