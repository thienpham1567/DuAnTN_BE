package shoesShop.common.Cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.CartItem.CartItem;
import shoesShop.common.CartItem.CartItemConverter;
import shoesShop.common.CartItem.CartItemService;
import shoesShop.common.CartItem.DbCartItem;
import shoesShop.common.CartItem.ICartItemRepository;
import shoesShop.common.ProductItem.DbProductItem;
import shoesShop.common.ProductItem.IProductItemRepository;
import shoesShop.common.ProductItem.ProductItem;

@Service
public class CartService implements ICartService {
	@Autowired
	ICartRepository cartRepo;

	@Autowired
	ICartItemRepository cartItemRepo;
	
	@Autowired
	IProductItemRepository productItemRepo;
	
	@Autowired
	CartItemService cartItemService;

	private CartConverter cartConverter = new CartConverter();
	
	private CartItemConverter cartItemConverter = new CartItemConverter();
	
	private HashMap<Integer, CartItem> cartItems = new HashMap<>();

	@Override
	public Cart add(String cartId, Integer quantity, ProductItem entity) {
		String newCartId = this.createCart(cartId);
		if (cartItems.containsKey(entity.productItemId)) {
			return this.update(cartId ,cartItems.get(entity.productItemId).cartItemId, quantity);
		}else {
			CartItem cartItem;
			Cart cart;
			if (newCartId == null) {
				cartItem = this.cartItemService.create(new CartItem(entity.productItemId, quantity, cartId));
				cart = this.cartConverter.convertDbToModel(this.updateCart(cartId));
			}else {				
				cartItem = this.cartItemService.create(new CartItem(entity.productItemId, quantity, newCartId));
				cart = this.cartConverter.convertDbToModel(this.updateCart(newCartId));
			}
			this.cartItems.put(entity.productItemId, cartItem);
			return cart;
		}
	}

	@Override
	public Cart remove(String cartId, Integer cartItemId) {
		this.cartItemService.delete(cartItemId);
		return this.cartConverter.convertDbToModel(this.updateCart(cartId));

	}

	@Override
	public Cart update(String cartId, Integer cartItemId, Integer quantity) {
		CartItem cartItem = this.cartItemConverter.convertDbToModel(this.cartItemRepo.findById(cartItemId).get());
		DbProductItem product = this.productItemRepo.findById(cartItem.productItemId).get();
		cartItem.quantity += quantity;
		cartItem.price = product.price * cartItem.quantity;
		this.cartItemService.update(cartItem, cartItem.cartItemId);
		return this.cartConverter.convertDbToModel(this.updateCart(cartId));
	}

	@Override
	public Cart clear() {
		this.cartItems.clear();
		this.cartItemRepo.deleteAll();
		return null;
	}

	@Override
	public Integer getTotalQuantity(String cartId) {
		Collection<DbCartItem> items = this.cartItemRepo.findAll();
		return items.stream().map(DbCartItem::getQuantity).reduce(0, Integer::sum);
	}

	@Override
	public Double getSubTotalPrice(String cartId) {
		Collection<DbCartItem> items = this.cartItemRepo.findAll();
		return items.stream().map(DbCartItem::getPrice).reduce(0.0, Double::sum);
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
