package shoesShop.common.CartItem;

import java.util.Collection;
import java.util.Iterator;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.Cart.ICartRepository;
import shoesShop.common.Product.IProductRepositoryService;
import shoesShop.common.Product.ProductConverter;
import shoesShop.common.ProductVariationSizes.DbProductVariationSize;
import shoesShop.common.ProductVariationSizes.IProductVariationSizeRepository;
import shoesShop.common.ProductVariationSizes.ProductVariationSizeConverter;
import shoesShop.common.Size.ISizeRepository;
import shoesShop.common.Color.ColorConverter;
import shoesShop.common.Color.IColorRepository;

@Service
public class CartItemService extends RecordManager<CartItem> {
	@Autowired
	ICartItemRepository cartItemRepo;

	@Autowired
	ICartRepository cartRepo;
	
	@Autowired
	IColorRepository colorRepo;

	@Autowired
	IProductVariationSizeRepository pvsRepo;

	@Autowired
	ISizeRepository sizeRepo;

	private CartItemConverter converter = new CartItemConverter();

	public Collection<CartItem> retrieveAll() {
		Collection<CartItem> cartItems = this.load(null, null, null, null).stream()
				.map(dbCartItem -> this.converter.convertDbToModel(dbCartItem)).collect(Collectors.toList());
		return cartItems;
	}

	public CartItem retrieveOne(Integer id) {
		CartItem cartItem = this.load(id, null, null, null).stream().map(dbCartItem -> this.converter.convertDbToModel(dbCartItem))
				.findFirst().get();
		return cartItem;
	}

	public CartItem create(CartItem record) {
		DbCartItem dbCartItem = this.converter.convertModelToDb(record);
		dbCartItem.imageUrl = record.imageUrl;
		dbCartItem.quantity = record.quantity;
		dbCartItem.color = this.colorRepo.findById(record.color.colorId).get();
		dbCartItem.price = record.productVariationSize.productVariation.product.price * record.quantity;
		dbCartItem.cart = this.cartRepo.findById(record.cartId).get();
		dbCartItem.productVariationSize = this.pvsRepo.findById(record.productVariationSize.productVariationSizeId)
				.get();
		DbCartItem createdCartItem = this.cartItemRepo.save(dbCartItem);
		return this.converter.convertDbToModel(createdCartItem);
	}

	public CartItem update(CartItem record) {
		DbCartItem dbCartItem = this.load(null, null, record.productVariationSize.productVariationSizeId, record.color.colorId).stream().findAny().orElse(null);
		if (dbCartItem != null) {
			DbCartItem updateCartItem = this.converter.convertModelToDb(record);
			this.converter.combine(dbCartItem, updateCartItem);
//			dbCartItem.cart = this.cartRepo.findById(record.cartId).get();
//			dbCartItem.productVariationSize = this.pvsRepo.findById(record.productVariationSize.productVariationSizeId).get();
			DbCartItem updateDbCartItem = this.cartItemRepo.save(dbCartItem);
			return this.converter.convertDbToModel(updateDbCartItem);
		}
		return null;
	}

	public Boolean delete(Integer id) {
		if (this.cartItemRepo.existsById(id)) {
			this.cartItemRepo.deleteById(id);
			return true;
		}
		return false;
	}

	public Collection<CartItem> retrieveAll(String cartId) {
		Collection<CartItem> cartItems = this.load(null, cartId, null, null).stream()
				.map(dbCartItem -> this.converter.convertDbToModel(dbCartItem)).collect(Collectors.toList());
		return cartItems;
	}

	public void deleteAll() {
		this.cartItemRepo.deleteAll();
	}

	private Collection<DbCartItem> load(Integer cartItemId, String cartId, Integer productVariationSizeId, Integer colorId) {
		Collection<DbCartItem> dbCartItems = this.cartItemRepo.findAll();
		for (DbCartItem dbCartItem2 : dbCartItems) {
			System.out.print(dbCartItem2.cartItemId);
		}
		if (cartItemId != null) {
			dbCartItems = dbCartItems.stream().filter(dbCartItem -> dbCartItem.cartItemId == cartItemId)
					.collect(Collectors.toList());
		}

		if (cartId != null) {
			dbCartItems = dbCartItems.stream().filter(dbCartItem -> dbCartItem.cart.cartId == cartId)
					.collect(Collectors.toList());
		}
		
		if (productVariationSizeId != null && colorId != null) {
			dbCartItems = dbCartItems.stream().filter(dbCartItem -> dbCartItem.productVariationSize.productVariationSizeId.intValue() == productVariationSizeId.intValue() && dbCartItem.color.colorId.intValue() == colorId.intValue())
					.collect(Collectors.toList());
		}

		return dbCartItems;
	}
}
