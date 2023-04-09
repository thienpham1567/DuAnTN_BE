package shoesShop.common.CartItem;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;

public class CartItemConverter implements ICombiner<DbCartItem>, IConverter<DbCartItem, CartItem>{

	@Override
	public void combine(DbCartItem original, DbCartItem update) {
		original.price = update.price;
		original.quantity = update.quantity;
	}
	
	@Override
	public DbCartItem convertModelToDb(CartItem input) {
		return input == null ? null : new DbCartItem(input.price, input.quantity);
	}

	@Override
	public CartItem convertDbToModel(DbCartItem input) {
		return input == null ? null : new CartItem(
				input.cartItemId,
				input.price,
				input.quantity,
				input.productItem.productItemId,
				input.cart.cartId
			);
	}
}
