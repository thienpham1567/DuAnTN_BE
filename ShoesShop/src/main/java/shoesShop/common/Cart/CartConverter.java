package shoesShop.common.Cart;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.CartItem.CartItem;
import shoesShop.common.CartItem.CartItemConverter;

public class CartConverter implements ICombiner<DbCart>, IConverter<DbCart, Cart>{
	private CartItemConverter cartItemConverter = new CartItemConverter();
	
	@Override
	public void combine(DbCart original, DbCart update) {
		original.itemSubtotalPrice = update.itemSubtotalPrice;
		original.itemTotalQuantity = update.itemTotalQuantity;
	}
	
	@Override
	public DbCart convertModelToDb(Cart input) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart convertDbToModel(DbCart input) {
		for (CartItem i : input.cartItems.stream().map(cartItem -> this.cartItemConverter.convertDbToModel(cartItem)).toList()) {
			System.out.print(i.productItemId + "+");
		}
		return input == null ? null : new Cart(
					input.cartId,
					input.itemTotalQuantity,
					input.itemSubtotalPrice,
					input.cartItems.stream().map(cartItem -> this.cartItemConverter.convertDbToModel(cartItem)).toList()
				);
	}
}
