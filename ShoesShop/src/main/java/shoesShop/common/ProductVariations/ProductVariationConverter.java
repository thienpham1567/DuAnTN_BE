package shoesShop.common.ProductVariations;

import java.util.Collection;

import shoesShop.common.IConverter;
import shoesShop.common.Color.ColorConverter;
import shoesShop.common.Product.ProductConverter;
import shoesShop.common.ProductImage.ProductImage;
import shoesShop.common.ProductImage.ProductImageConverter;
import shoesShop.common.ProductVariationSizes.ProductVariationSize;
import shoesShop.common.ProductVariationSizes.ProductVariationSizeConverter;

public class ProductVariationConverter implements IConverter<DbProductVariation, ProductVariation>{

	private ProductVariationSizeConverter pvsConverter = new ProductVariationSizeConverter();
	private ProductImageConverter piConverter = new ProductImageConverter();
	private ColorConverter colorConverter = new ColorConverter();
	private ProductConverter productConverter = new ProductConverter();

	@Override
	public DbProductVariation convertModelToDb(ProductVariation input) {
		return null;
	}

	@Override
	public ProductVariation convertDbToModel(DbProductVariation input) {
		Collection<ProductVariationSize> pvss = input.productVariationSizes
				.stream()
				.map(pvs -> this.pvsConverter.convertDbToModel(pvs)).toList();
		Collection<ProductImage> pis = input.productImages
				.stream()
				.map(pi -> this.piConverter.convertDbToModel(pi)).toList();
		return input == null ? null : new ProductVariation(
					input.productVariationId,
					this.productConverter.convertDbToModel(input.product),
					this.colorConverter.convertDbToModel(input.color),
					pvss,
					pis
				);
	}

}
