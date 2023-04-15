package shoesShop.common.Brand;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;

public class BrandConverter implements ICombiner<DbBrand>, IConverter<DbBrand, Brand> {
	@Override
	public void combine(DbBrand original, DbBrand update) {
		original.name = update.name;
	}

	@Override
	public DbBrand convertModelToDb(Brand input) {
		return input == null ? null : new DbBrand(input.name);
	}

	@Override
	public Brand convertDbToModel(DbBrand input) {
		return input == null ? null : new Brand(input.brandId, input.name);
	}
}
