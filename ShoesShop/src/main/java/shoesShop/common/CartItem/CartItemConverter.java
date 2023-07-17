package shoesShop.common.CartItem;

import shoesShop.common.Color.ColorConverter;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.Product.ProductConverter;
import shoesShop.common.ProductVariationSizes.ProductVariationSizeConverter;

public class CartItemConverter implements ICombiner<DbCartItem>, IConverter<DbCartItem, CartItem>{
	private ProductVariationSizeConverter pvsConverter = new ProductVariationSizeConverter();
	private ColorConverter colorConverter = new ColorConverter();
	
	@Override
	public void combine(DbCartItem original, DbCartItem update) {
		original.quantity = update.quantity;
		original.price = update.quantity * original.productVariationSize.productVariation.product.price;
		original.imageUrl = update.imageUrl;
	}
	
	@Override
	public DbCartItem convertModelToDb(CartItem input) {
		return new DbCartItem(input.price,input.quantity, input.imageUrl);
	}

	@Override
	public CartItem convertDbToModel(DbCartItem input) {
		return input == null ? null : new CartItem(
				input.cartItemId,
				input.cart.cartId,
				input.price,
				input.quantity,
				input.imageUrl,
				this.pvsConverter.convertDbToModel(input.productVariationSize),
				this.colorConverter.convertDbToModel(input.color)
			);
	}
}
