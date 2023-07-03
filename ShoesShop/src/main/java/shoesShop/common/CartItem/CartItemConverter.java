package shoesShop.common.CartItem;

import shoesShop.common.Color.ColorConverter;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.Product.ProductConverter;
import shoesShop.common.ProductVariationSizes.ProductVariationSizeConverter;

public class CartItemConverter implements ICombiner<DbCartItem>, IConverter<DbCartItem, CartItem>{
	private ProductConverter productConverter = new ProductConverter();
	private ColorConverter colorConverter = new ColorConverter();
	private ProductVariationSizeConverter pvsConverter = new ProductVariationSizeConverter();
	
	@Override
	public void combine(DbCartItem original, DbCartItem update) {
		original.price = update.price;
		original.quantity = update.quantity;
		original.color = update.color;
		original.product = update.product;
		original.imageUrl = update.imageUrl;
		original.productVariationSize = update.productVariationSize;
	}
	
	@Override
	public DbCartItem convertModelToDb(CartItem input) {
		return input == null ? null : new DbCartItem(input.cartId ,input.price, input.quantity, 
				this.productConverter.convertModelToDb(input.product), 
				this.colorConverter.convertModelToDb(input.color), 
				this.pvsConverter.convertModelToDb(input.productVariationSize));
	}

	@Override
	public CartItem convertDbToModel(DbCartItem input) {
		return input == null ? null : new CartItem(
				input.cartItemId,
				input.cart.cartId,
				input.price,
				input.quantity,
				this.productConverter.convertDbToModel(input.product),
				this.colorConverter.convertDbToModel(input.color),
				this.pvsConverter.convertDbToModel(input.productVariationSize)
			);
	}
}
