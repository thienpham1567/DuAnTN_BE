package shoesShop.converter;

import shoesShop.entity.DbBrand;
import shoesShop.model.Brand;

public class BrandConverter implements IConverter<DbBrand, Brand>{

	@Override
	public DbBrand convertModelToDb(Brand input) {
		return input == null ? null : new DbBrand(input.name);
	}

	@Override
	public Brand convertDbToModel(DbBrand input) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
