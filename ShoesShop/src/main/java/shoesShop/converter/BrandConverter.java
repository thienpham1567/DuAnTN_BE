package shoesShop.converter;

import shoesShop.entity.DbBrand;
import shoesShop.model.Brand;

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
		return input == null ? null : new Brand(input.name, input.brandId);
	}
}
