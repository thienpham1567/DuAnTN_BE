package shoesShop.common.Product;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;

public class ProductConverter implements ICombiner<DbProduct>, IConverter<DbProduct, Product>{	
	@Override
	public void combine(DbProduct original, DbProduct update) {
		original.category = update.category;
		original.brand = update.brand;
		original.name = update.name;
		original.description = update.description;
		original.updateAt = update.updateAt;
	}

	@Override
	public DbProduct convertModelToDb(Product input) {
		return input == null ? null : new DbProduct(
					input.name,
					input.desciption
				);
	}

	@Override
	public Product convertDbToModel(DbProduct input) {
		return input == null ? null : new Product(
				input.name,
				input.description,
				input.productId,
				input.brand.brandId,
				input.category.categoryId
			);
	}
}