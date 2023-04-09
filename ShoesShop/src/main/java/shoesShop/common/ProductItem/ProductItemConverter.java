package shoesShop.common.ProductItem;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;

public class ProductItemConverter implements ICombiner<DbProductItem>, IConverter<DbProductItem, ProductItem> {
	@Override
	public void combine(DbProductItem original, DbProductItem update) {
		
	}

	@Override
	public DbProductItem convertModelToDb(ProductItem input) {
		return input == null ? null : new DbProductItem();
	}

	@Override
	public ProductItem convertDbToModel(DbProductItem input) {
		return input == null ? null : new ProductItem(
					input.productItemId,
					input.sku,
					input.price,
					input.quantityInStock,
					input.imageUrl,
					input.status,
					input.size.sizeId,
					input.color.colorId,
					input.product.productId
				);
	}
}
