package shoesShop.common.Ward;

import shoesShop.common.IConverter;

public class WardConverter implements IConverter<DbWard, Ward>{

	@Override
	public DbWard convertModelToDb(Ward input) {
		return null;
	}

	@Override
	public Ward convertDbToModel(DbWard input) {
		return input == null ? null : new Ward(input.wardId, input.name, input.prefix, input.district.districtId, input.province.provinceId);
	}
	
}
