package shoesShop.common.Address;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;

public class AddressConverter implements ICombiner<DbAddress>, IConverter<DbAddress, Address>{
	@Override
	public void combine(DbAddress original, DbAddress update) {
		original.address = update.address;
		original.ward = update.ward;
		original.district = update.district;
		original.province = update.province;
	}
	
	@Override
	public DbAddress convertModelToDb(Address input) {
		return input == null ? null : new DbAddress(input.address, input.ward, input.district, input.province);
	}

	@Override
	public Address convertDbToModel(DbAddress input) {
		return input == null ? null : new Address(input.addressId, input.address, input.ward, input.district, input.province);
	}
}
