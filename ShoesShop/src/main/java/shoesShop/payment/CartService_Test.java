//package shoesShop.payment;
//import java.util.Collection;
//import java.util.HashMap;
//import java.util.UUID;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.paypal.api.payments.Payment;
//import com.paypal.base.rest.PayPalRESTException;
//
//import shoesShop.common.Cart.Cart;
//import shoesShop.common.Cart.CartConverter;
//import shoesShop.common.Cart.DbCart;
//import shoesShop.common.Cart.ICartRepository;
//import shoesShop.common.Cart.ICartService;
//import shoesShop.common.CartItem.CartItem;
//import shoesShop.common.CartItem.CartItemService;
//
//@Service
//public class CartService implements ICartService {
//	@Autowired
//	ICartRepository cartRepo;
//	
//	@Autowired
//	CartItemService cartItemService;
//
//	private CartConverter cartConverter = new CartConverter();
//	
//	private HashMap<String, CartItem> cartItems = new HashMap<>();
//
//	@Autowired
//	private PaypalService paypalService;
//	    
//	    public boolean processPayment(Cart cart) {
//	        try {
//	            // Tạo thông tin thanh toán PayPal dựa trên thông tin trong giỏ hàng
//	            Double totalAmount = cart.getItemSubtotalPrice();
//	            String currency = "USD"; // Loại tiền tệ, bạn có thể thay đổi nếu cần
//	            String method = "paypal"; // Phương thức thanh toán, bạn có thể thay đổi nếu cần
//	            String intent = "sale"; // Mục đích thanh toán, bạn có thể thay đổi nếu cần
//	            String description = "Thanh toán đơn hàng"; // Mô tả thanh toán, bạn có thể thay đổi nếu cần
//	            String cancelUrl = "http://example.com/cancel"; // URL khi hủy thanh toán, bạn có thể thay đổi nếu cần
//	            String successUrl = "http://example.com/success"; // URL khi thanh toán thành công, bạn có thể thay đổi nếu cần
//	            
//	            // Gọi phương thức createPayment() trong PaypalService để tạo thông tin thanh toán PayPal
//	            Payment payment = paypalService.createPayment(totalAmount, currency, method, intent, description, cancelUrl, successUrl);
//	            
//	            // Kiểm tra trạng thái thanh toán
//	            if (payment.getState().equals("created")) {
//	                // Chuyển hướng người dùng đến trang thanh toán PayPal
//	                String redirectUrl = payment.getLinks().stream()
//	                        .filter(link -> link.getRel().equals("approval_url"))
//	                        .findFirst()
//	                        .orElseThrow(() -> new RuntimeException("Không tìm thấy URL chuyển hướng thanh toán"))
//	                        .getHref();
//	                
//	                // Thực hiện chuyển hướng đến URL thanh toán PayPal
//	                
//	                // Sau khi người dùng hoàn tất thanh toán trên PayPal và trở về URL successUrl,
//	                // bạn cần triển khai phương thức successPay() trong controller để xử lý thành công thanh toán và cập nhật giỏ hàng
//	                
//	                return true;
//	            }
//	        } catch (PayPalRESTException e) {
//	            e.printStackTrace();
//	        }
//	        
//	        return false;
//	    }
//	
//	@Override
//	public Cart add(String cartId, CartItem cartItem) {
//		String newCartId = this.createCart(cartId);
//		String keyCartItem = cartItem.productVariationSize.productVariationSizeId + "" + cartItem.color.value;
//		if (cartItems.containsKey(keyCartItem)) {
//			System.out.print(cartItem.productVariationSize.productVariationSizeId);
//			System.out.print(cartItem.color.colorId);
//			return this.update(cartId ,cartItem);
//		}else {
//			Cart cart;
//			if (newCartId == null) {
//				cartItem.cartId = cartId;
//				cartItem = this.cartItemService.create(cartItem);
//				cart = this.cartConverter.convertDbToModel(this.updateCart(cartId));
//			}else {
//				cartItem.cartId = newCartId;
//				cartItem = this.cartItemService.create(cartItem);
//				cart = this.cartConverter.convertDbToModel(this.updateCart(newCartId));
//			}
//			this.cartItems.put(cartItem.productVariationSize.productVariationSizeId + "" + cartItem.color.value, cartItem);
//			return cart;
//		}
//	}
//
//	@Override
//	public Cart remove(String cartId, Integer cartItemId) {
//		CartItem item = this.cartItemService.retrieveOne(cartItemId);
//		this.cartItems.remove(item.cartId);
//		this.cartItemService.delete(item.cartItemId);
//		return this.cartConverter.convertDbToModel(this.updateCart(cartId));
//	}
//
//	@Override
//	public Cart update(String cartId, CartItem cartItem) {
//		this.cartItemService.update(cartItem);
//		return this.cartConverter.convertDbToModel(this.updateCart(cartId));
//	}
//
//	@Override
//	public Cart clear() {
//		this.cartItems.clear();
//		this.cartItemService.deleteAll();
//		return null;
//	}
//
//	@Override
//	public Integer getTotalQuantity(String cartId) {
//		Collection<CartItem> items = this.cartItemService.retrieveAll(cartId);
//		return items.stream().map(CartItem::getQuantity).reduce(0, Integer::sum);
//	}
//
//	@Override
//	public Double getSubTotalPrice(String cartId) {
//		Collection<CartItem> items = this.cartItemService.retrieveAll(cartId);
//		return items.stream().map(CartItem::getPrice).reduce(0.0, Double::sum);
//	}
//	
//	private DbCart updateCart(String cartId) {
//		DbCart dbCart = this.cartRepo.findById(cartId).get();
//		dbCart.itemSubtotalPrice = this.getSubTotalPrice(dbCart.cartId);
//		dbCart.itemTotalQuantity = this.getTotalQuantity(dbCart.cartId);
//		return this.cartRepo.save(dbCart);
//	}
//	
//	private String createCart(String cartId) {
//		if (cartId == null || !this.cartRepo.existsById(cartId)) {
//			DbCart cart = new DbCart(UUID.randomUUID().toString());
//			return this.cartRepo.save(cart).cartId;
//		}
//		return null;
//	}
//	
//	
//}
