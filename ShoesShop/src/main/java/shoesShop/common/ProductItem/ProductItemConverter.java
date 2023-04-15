package shoesShop.common.ProductItem;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.Product.ProductConverter;

public class ProductItemConverter implements ICombiner<DbProductItem>, IConverter<DbProductItem, ProductItem> {
	private ProductConverter converterProduct = new ProductConverter();
	
	@Override
	public void combine(DbProductItem original, DbProductItem update) {
		original.color = update.color;
		original.imageUrl = update.imageUrl;
		original.price = update.price;
		original.productItemId = update.productItemId;
		original.quantityInStock = update.quantityInStock;
		original.sku = update.sku;
		original.size = update.size;
		original.product = update.product;
		original.status = update.status;
	}

	@Override
	public DbProductItem convertModelToDb(ProductItem input) {
		return input == null ? null : new DbProductItem(
				input.colorId,
				input.imageUrl,
				input.price,
				input.quantityInStock,
				input.sku,
				input.productItemId,
				input.status,
				input.sizeId,
				input.product.productId
				);
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
					this.converterProduct.convertDbToModel(input.product)
				);
	}
}
