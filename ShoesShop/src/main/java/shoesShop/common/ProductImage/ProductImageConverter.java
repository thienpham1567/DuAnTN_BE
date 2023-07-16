package shoesShop.common.ProductImage;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.Color.Color;
import shoesShop.common.Color.ColorConverter;
import shoesShop.common.Product.Product;
import shoesShop.common.Product.ProductConverter;
import shoesShop.common.ProductVariations.ProductVariation;

public class ProductImageConverter implements ICombiner<DbProductImage>, IConverter<DbProductImage, ProductImage> {
	
	private ColorConverter colorConverter = new ColorConverter();
	private ProductConverter productConverter = new ProductConverter();
	
	@Override
	public void combine(DbProductImage original, DbProductImage update) {
		original.productImageld = update.productImageld;
		original.imageUrl = update.imageUrl;
		original.isPrimary = update.isPrimary;
		original.productVariation = update.productVariation;
	}
	
	@Override
	public DbProductImage convertModelToDb(ProductImage input) {
		return input == null ? null : new DbProductImage(
					input.imageUrl,
					input.isPrimary,
					input.productImageld
				);
	}

	@Override
	public ProductImage convertDbToModel(DbProductImage input) {
		Product product = this.productConverter.convertDbToModel(input.productVariation.product);
		Color color = this.colorConverter.convertDbToModel(input.productVariation.color);
		return input == null ? null : new ProductImage(
					input.productImageld,
					input.imageUrl,
					input.isPrimary,
					new ProductVariation(input.productVariation.productVariationId, product, color)
				);
	}

}
