package shoesShop.common.Product;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.ProductDetails.ProductDTO;

public class ProductConverter implements ICombiner<DbProduct>, IConverter<DbProduct, Product>{	
	@Override
	public void combine(DbProduct original, DbProduct update) {
		original.name = update.name;
		original.price = update.price;
		original.sku = update.sku;
		original.description = update.description;
		original.category = update.category;
		original.brand = update.brand;
		original.description = update.description;
		original.updatedAt = update.updatedAt;
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
				input.brand.brandId,
				input.category.categoryId
			);
	}

}