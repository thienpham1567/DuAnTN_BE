//package shoesShop.common.CartItem;
//
//import java.util.Collection;
//import java.util.stream.Collectors;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import shoesShop.common.RecordManager;
//import shoesShop.common.Cart.ICartRepository;
//import shoesShop.common.ProductItem.DbProductItem;
//import shoesShop.common.ProductItem.IProductItemRepository;
//
//@Service
//public class CartItemService extends RecordManager<CartItem>{
//	@Autowired
//	ICartItemRepository cartItemRepo;
//	
//	@Autowired
//	IProductItemRepository productItemRepo;
//	
//	@Autowired
//	ICartRepository cartRepo;
//	
//	private CartItemConverter converter = new CartItemConverter();
//	
//	public Collection<CartItem> retrieveAll() {
//		Collection<CartItem> cartItems = this.load(null,null).stream()
//				.map(dbCartItem -> this.converter.convertDbToModel(dbCartItem)).collect(Collectors.toList());
//		return cartItems;
//	}
//
//	public CartItem retrieveOne(Integer id) {
//		CartItem cartItem = this.load(id,null).stream()
//				.map(dbCartItem -> this.converter.convertDbToModel(dbCartItem)).findFirst().get();
//		return cartItem;
//	}
//
//	public CartItem create(CartItem record) { 
//		DbCartItem dbCartItem = this.converter.convertModelToDb(record);
//		dbCartItem.price = this.calculateTotalPrice(record.productItemId, record.quantity);
//		dbCartItem.productItem = this.productItemRepo.findById(record.productItemId).get();
//		dbCartItem.cart = this.cartRepo.findById(record.cartId).get();
//		DbCartItem createdCartItem = this.cartItemRepo.save(dbCartItem);
//		return this.converter.convertDbToModel(createdCartItem);
//	}
//
//	public CartItem update(CartItem record, Integer id) {
//		DbCartItem dbCartItem = this.cartItemRepo.findById(id).get();
//		if (dbCartItem != null) {			
//			DbCartItem updateCartItem = this.converter.convertModelToDb(record);
//			updateCartItem.productItem = this.productItemRepo.findById(record.productItemId).get();
//			updateCartItem.cart = this.cartRepo.findById(record.cartId).get();
//			this.converter.combine(dbCartItem, updateCartItem);
//			updateCartItem.price = this.calculateTotalPrice(updateCartItem.productItem.productItemId, updateCartItem.quantity);
//			DbCartItem updateDbCartItem = this.cartItemRepo.save(dbCartItem);
//			return this.converter.convertDbToModel(updateDbCartItem);
//		}
//		
//		return null;
//	}
//
//	public Boolean delete(Integer id) {
//		if (this.cartItemRepo.existsById(id)) {
//			this.cartItemRepo.deleteById(id);
//			return true;
//		}
//
//		return false;
//	}
//	
//	public Collection<CartItem> retrieveAll(String cartId) {
//		Collection<CartItem> cartItems = this.load(null,cartId).stream()
//				.map(dbCartItem -> this.converter.convertDbToModel(dbCartItem)).collect(Collectors.toList());
//		return cartItems;
//	}
//	
//	private Collection<DbCartItem> load(Integer cartItemId, String cartId) {
//		Collection<DbCartItem> dbCartItems = this.cartItemRepo.findAll();
//		
//		if (cartItemId != null) {
//			dbCartItems = dbCartItems.stream().filter(dbCartItem -> dbCartItem.cartItemId == cartItemId)
//					.collect(Collectors.toList());
//		}
//		
//		if (cartId != null) {
//			dbCartItems = dbCartItems.stream().filter(dbCartItem -> dbCartItem.cart.cartId == cartId)
//					.collect(Collectors.toList());
//		}
//
//		return dbCartItems;
//	}
//	
//	private Double calculateTotalPrice(Integer productItemId, Integer quantity) {
//		DbProductItem productItem = this.productItemRepo.findById(productItemId).get();
//		return productItem.price * quantity;
//	}
//}
