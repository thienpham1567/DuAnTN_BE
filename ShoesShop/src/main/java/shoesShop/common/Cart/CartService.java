package shoesShop.common.Cart;

import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.CartItem.DbCartItem;
import shoesShop.common.CartItem.ICartItemRepository;
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

	private CartConverter converter = new CartConverter();
	
	private DbCart cart = new DbCart(UUID.randomUUID().toString());
	private HashMap<Integer, DbCartItem> cartItems = new HashMap<>();

	@Override
	public void add(Integer quantity, ProductItem entity) {
		if (this.cartItems.containsKey(entity.productItemId)) {
			this.update(entity.productItemId, quantity);
		} else {
			DbCart cart = this.cartRepo.save(this.cart);
			DbCartItem dbCartItem = new DbCartItem();
			dbCartItem.productItem = this.productItemRepo.findById(entity.productItemId).get();
			dbCartItem.quantity = quantity;
			dbCartItem.cart = cart;
		}
	}

	@Override
	public void remove(Integer productItemId) {
		DbCartItem dbCartItem = this.cartItemRepo.findById(productItemId).get();
		if (this.cartItemRepo.existsById(dbCartItem.cartItemId)) {			
			this.cartItemRepo.delete(dbCartItem);
		}
	}

	@Override
	public void update(Integer productItemId, Integer quantity) {
		DbCartItem dbCartItem = this.cartItemRepo.findById(productItemId).get();
		dbCartItem.quantity = quantity;
		this.cartItemRepo.save(dbCartItem);
	}

	@Override
	public void clear() {
		this.cartItems.clear();
		this.cartItemRepo.deleteAll();
	}

	@Override
	public Collection<DbCartItem> getCart() {
		return this.cartItems.values();
	}

	@Override
	public Integer getTotalQuantity() {
		return this.cartItems.values().stream().map(DbCartItem::getQuantity).reduce(0, Integer::sum);
	}

	@Override
	public Double getSubTotalPrice() {
		return this.cartItems.values().stream().map(DbCartItem::getPrice).reduce(0.0, Double::sum);
	}
}
