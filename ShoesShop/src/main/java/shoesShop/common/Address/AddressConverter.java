package shoesShop.common.Address;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.District.DistrictConverter;
import shoesShop.common.Province.ProvinceConverter;
import shoesShop.common.Ward.WardConverter;

public class AddressConverter implements ICombiner<DbAddress>, IConverter<DbAddress, Address> {
	private WardConverter wardConverter = new WardConverter();
	private ProvinceConverter provinceConverter = new ProvinceConverter();
	private DistrictConverter districtConverter = new DistrictConverter();

	@Override
	public void combine(DbAddress original, DbAddress update) {
		original.address = update.address;
		original.ward = update.ward;
		original.district = update.district;
		original.province = update.province;
	}

	@Override
	public DbAddress convertModelToDb(Address input) {
		return input == null ? null : new DbAddress(input.address);
	}

	@Override
	public Address convertDbToModel(DbAddress input) {
		return input == null ? null
				: new Address(input.addressId, input.address, input.ward.wardId, input.district.districtId, input.province.provinceId);
	}
}
