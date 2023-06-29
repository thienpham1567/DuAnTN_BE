package shoesShop.common.ProductVariationSizes;

import shoesShop.common.IConverter;
import shoesShop.common.Color.Color;
import shoesShop.common.ProductVariations.ProductVariation;
import shoesShop.common.Size.Size;

public class ProductVariationSizeConverter implements IConverter<DbProductVariationSize, ProductVariationSize>{
	
	@Override
	public DbProductVariationSize convertModelToDb(ProductVariationSize input) {
		return null;
	}

	@Override
	public ProductVariationSize convertDbToModel(DbProductVariationSize input) {
		Size size = new Size(input.size.sizeId, input.size.value, input.size.category.categoryId);
		return input == null ? null : new ProductVariationSize(
					input.productVariationSizeId,
					input.quantity,
					size
				);
	}

}
