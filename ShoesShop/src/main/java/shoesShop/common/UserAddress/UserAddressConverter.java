package shoesShop.common.UserAddress;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.Address.AddressConverter;
import shoesShop.common.User.UserConverter;

public class UserAddressConverter implements ICombiner<DbUserAddress>, IConverter<DbUserAddress, UserAddress> {
	private UserConverter userConverter = new UserConverter();
	private AddressConverter addressConverter = new AddressConverter();

	@Override
	public void combine(DbUserAddress original, DbUserAddress update) {
		original.address = update.address;
		original.user = update.user;
		original.isDefault = update.isDefault;
	}

	@Override
	public DbUserAddress convertModelToDb(UserAddress input) {
		return input == null ? null : new DbUserAddress(input.isDefault);
	}

	@Override
	public UserAddress convertDbToModel(DbUserAddress input) {
		return input == null ? null : new UserAddress(input.userAddressId, input.isDefault, input.address.addressId, input.user.userId);
	}
}
