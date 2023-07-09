package shoesShop.common.ProductVariationSizes;

import shoesShop.common.IConverter;
import shoesShop.common.Category.CategoryConverter;
import shoesShop.common.Color.Color;
import shoesShop.common.Color.ColorConverter;
import shoesShop.common.Product.Product;
import shoesShop.common.Product.ProductConverter;
import shoesShop.common.ProductVariations.ProductVariation;
import shoesShop.common.Size.Size;

public class ProductVariationSizeConverter implements IConverter<DbProductVariationSize, ProductVariationSize>{
	private CategoryConverter categoryConverter = new CategoryConverter();
	private ColorConverter colorConverter = new ColorConverter();
	private ProductConverter productConverter = new ProductConverter();
	
	
	@Override
	public DbProductVariationSize convertModelToDb(ProductVariationSize input) {
		return input == null ? null : new DbProductVariationSize(
					input.productVariationSizeId
				);
	}

	@Override
	public ProductVariationSize convertDbToModel(DbProductVariationSize input) {
		Size size = new Size(input.size.sizeId, input.size.value, input.size.code, categoryConverter.convertDbToModel(input.size.category));
		Product product = this.productConverter.convertDbToModel(input.productVariation.product);
		Color color = this.colorConverter.convertDbToModel(input.productVariation.color);
		return input == null ? null : new ProductVariationSize(
					input.productVariationSizeId,
					input.quantity,
					size,
					new ProductVariation(input.productVariation.productVariationId, product, color)
				);
	}
}
