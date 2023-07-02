package shoesShop.common.ProductImage;

import shoesShop.common.IConverter;
import shoesShop.common.ProductVariations.ProductVariationConverter;

public class ProductImageConverter implements IConverter<DbProductImage, ProductImage> {
	@Override
	public DbProductImage convertModelToDb(ProductImage input) {
		return null;
	}

	@Override
	public ProductImage convertDbToModel(DbProductImage input) {
		return input == null ? null : new ProductImage(
					input.productImageld,
					input.imageUrl,
					input.isPrimary
				);
	}

}
