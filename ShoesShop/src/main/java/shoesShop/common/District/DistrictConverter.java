package shoesShop.common.District;

import shoesShop.common.IConverter;

public class DistrictConverter implements IConverter<DbDistrict, District> {

	@Override
	public DbDistrict convertModelToDb(District input) {
		return null;
	}

	@Override
	public District convertDbToModel(DbDistrict input) {
		return input == null ? null : new District(input.districtId,input.name,input.prefix, input.province.provinceId);
	}

}
