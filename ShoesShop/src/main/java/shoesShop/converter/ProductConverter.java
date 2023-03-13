package shoesShop.converter;

import shoesShop.entity.DbProduct;
import shoesShop.model.Product;

public class ProductConverter implements ICombiner<DbProduct>, IConverter<Product, DbProduct>{
	@Override
	public void combine(DbProduct original, DbProduct update) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DbProduct convertDbToModel(Product input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product convertModelToDb(DbProduct input) {
		// TODO Auto-generated method stub
		return null;
	}
}