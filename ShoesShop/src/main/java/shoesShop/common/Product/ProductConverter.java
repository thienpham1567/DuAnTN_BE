package shoesShop.common.Product;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.Brand.BrandConverter;
import shoesShop.common.Category.CategoryConverter;

public class ProductConverter implements ICombiner<DbProduct>, IConverter<DbProduct, Product>{	
	private BrandConverter brandConverter = new BrandConverter();
	private CategoryConverter categoryConverter = new CategoryConverter();
	
	@Override
	public void combine(DbProduct original, DbProduct update) {
		original.category = update.category;
		original.brand = update.brand;
		original.name = update.name;
		original.description = update.description;
		original.createdAt = update.updatedAt;
	}

	@Override
	public DbProduct convertModelToDb(Product input) {
		return input == null ? null : new DbProduct(
					input.name,
					input.price,
					input.sku,
					input.description,
					input.createdAt,
					input.updatedAt
				);
	}

	@Override
	public Product convertDbToModel(DbProduct input) {
		return input == null ? null : new Product(
				input.name,
				input.price,
				input.sku,
				input.description,
				input.createdAt,
				input.updatedAt,
				input.productId,
				this.brandConverter.convertDbToModel(input.brand),
				this.categoryConverter.convertDbToModel(input.category)
			);
	}
}