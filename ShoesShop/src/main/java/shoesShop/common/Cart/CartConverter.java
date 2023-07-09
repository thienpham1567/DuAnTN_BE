package shoesShop.common.Cart;

import java.util.stream.Collectors;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.CartItem.CartItem;
import shoesShop.common.CartItem.CartItemConverter;
import shoesShop.common.User.UserConverter;

public class CartConverter implements ICombiner<DbCart>, IConverter<DbCart, Cart> {
	private CartItemConverter cartItemConverter = new CartItemConverter();
	private UserConverter userConverter = new UserConverter();

	@Override
	public void combine(DbCart original, DbCart update) {
		original.itemSubtotalPrice = update.itemSubtotalPrice;
		original.itemTotalQuantity = update.itemTotalQuantity;
	}

	@Override
	public DbCart convertModelToDb(Cart input) {
		return input == null ? null
				: new DbCart(input.cartId, input.itemSubtotalPrice, input.itemTotalQuantity,
						this.userConverter.convertModelToDb(input.user));
	}

	@Override
	public Cart convertDbToModel(DbCart input) {
		return input == null ? null
				: new Cart(input.cartId, input.itemTotalQuantity, input.itemSubtotalPrice,
						this.userConverter.convertDbToModel(input.user), input.cartItems.stream()
								.map(cartItem -> this.cartItemConverter.convertDbToModel(cartItem)).collect(Collectors.toList());
	}
}
