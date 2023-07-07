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
		original.quantity = original.quantity + update.quantity;
		original.price = original.quantity * update.price;
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
				this.productConverter.convertDbToModel(input.product),
				this.colorConverter.convertDbToModel(input.color),
				this.pvsConverter.convertDbToModel(input.productVariationSize)
			);
	}
}
