package shoesShop.common.Province;

import shoesShop.common.IConverter;

public class ProvinceConverter implements IConverter<DbProvince, Province>{

	@Override
	public DbProvince convertModelToDb(Province input) {
		return null;
	}

	@Override
	public Province convertDbToModel(DbProvince input) {
		return input == null ? null : new Province(input.provinceId, input.name, input.code);
	}
	
}
