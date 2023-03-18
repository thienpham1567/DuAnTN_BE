package shoesShop.converter;

import shoesShop.entity.DbProduct;
import shoesShop.model.Product;

public class ProductConverter implements ICombiner<DbProduct>, IConverter<Product, DbProduct>{	
	@Override
	public void combine(DbProduct original, DbProduct update) {
		original.category = update.category;
		original.brand = update.brand;
		original.name = update.name;
		original.imageLink = update.imageLink;
		original.price = update.price;
		original.inStock = update.inStock;
		original.isAvailable = update.isAvailable;
	}

	@Override
	public DbProduct convertModelToDb(Product input) {
		return input == null ? null : new DbProduct(
					input.name,
					input.imageLink,
					input.price,
					input.inStock,
					input.isAvailable,
					input.created
				);
	}

	@Override
	public Product convertDbToModel(DbProduct input) {
		return input == null ? null : new Product(
				input.productId,
				input.name,
				input.imageLink,
				input.price,
				input.inStock,
				input.isAvailable,
				input.brand.brandId,
				input.category.categoryId
			);
	}
}