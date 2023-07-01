package shoesShop.common.ProductVariationSizes;

import shoesShop.common.IConverter;
import shoesShop.common.Category.CategoryConverter;
import shoesShop.common.Size.Size;

public class ProductVariationSizeConverter implements IConverter<DbProductVariationSize, ProductVariationSize>{
	private CategoryConverter categoryConverter = new CategoryConverter();
	
	@Override
	public DbProductVariationSize convertModelToDb(ProductVariationSize input) {
		return null;
	}

	@Override
	public ProductVariationSize convertDbToModel(DbProductVariationSize input) {
		Size size = new Size(input.size.sizeId, input.size.value, input.size.code, categoryConverter.convertDbToModel(input.size.category));
		return input == null ? null : new ProductVariationSize(
					input.productVariationSizeId,
					input.quantity,
					size
				);
	}

}
