package shoesShop.common.Cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.CartItem.CartItem;
import shoesShop.common.CartItem.CartItemService;

@Service
public class CartService implements ICartService {
	@Autowired
	ICartRepository cartRepo;
	
	@Autowired
	CartItemService cartItemService;

	private CartConverter cartConverter = new CartConverter();
	
	private HashMap<Integer, CartItem> cartItems = new HashMap<>();

	@Override
	public Cart add(String cartId, CartItem cartItem) {
		String newCartId = this.createCart(cartId);
		if (cartItems.containsKey(cartItem.cartItemId)) {
			return this.update(cartId ,cartItem);
		}else {
			Cart cart;
			if (newCartId == null) {
				cartItem.cartId = cartId;
				cartItem = this.cartItemService.create(cartItem);
				cart = this.cartConverter.convertDbToModel(this.updateCart(cartId));
			}else {
				cartItem.cartId = newCartId;
				cartItem = this.cartItemService.create(cartItem);
				cart = this.cartConverter.convertDbToModel(this.updateCart(newCartId));
			}
			this.cartItems.put(cartItem.cartItemId, cartItem);
			return cart;
		}
	}

	@Override
	public Cart remove(String cartId, Integer cartItemId) {
		CartItem item = this.cartItemService.retrieveOne(cartItemId);
		this.cartItems.remove(item.cartItemId);
		this.cartItemService.delete(item.cartItemId);
		return this.cartConverter.convertDbToModel(this.updateCart(cartId));
	}

	@Override
	public Cart update(String cartId, CartItem cartItem) {
		this.cartItemService.update(cartItem, cartItem.cartItemId);
		return this.cartConverter.convertDbToModel(this.updateCart(cartId));
	}

	@Override
	public Cart clear() {
		this.cartItems.clear();
		this.cartItemService.deleteAll();
		return null;
	}

	@Override
	public Integer getTotalQuantity(String cartId) {
		Collection<CartItem> items = this.cartItemService.retrieveAll(cartId);
		return items.stream().map(CartItem::getQuantity).reduce(0, Integer::sum);
	}

	@Override
	public Double getSubTotalPrice(String cartId) {
		Collection<CartItem> items = this.cartItemService.retrieveAll(cartId);
		return items.stream().map(CartItem::getPrice).reduce(0.0, Double::sum);
	}
	
	private DbCart updateCart(String cartId) {
		DbCart dbCart = this.cartRepo.findById(cartId).get();
		dbCart.itemSubtotalPrice = this.getSubTotalPrice(dbCart.cartId);
		dbCart.itemTotalQuantity = this.getTotalQuantity(dbCart.cartId);
		return this.cartRepo.save(dbCart);
	}
	
	private String createCart(String cartId) {
		if (cartId == null || !this.cartRepo.existsById(cartId)) {
			DbCart cart = new DbCart(UUID.randomUUID().toString());
			return this.cartRepo.save(cart).cartId;
		}
		return null;
	}
}
