package shoesShop.payment;

import java.util.Collection;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import io.jsonwebtoken.ExpiredJwtException;
import shoesShop.common.Cart.Cart;
import shoesShop.common.Cart.CartService;
import shoesShop.common.CartItem.CartItem;
import shoesShop.common.CartItem.CartItemService;
import shoesShop.common.Color.IColorRepository;
import shoesShop.common.Order.IOrderRepository;
import shoesShop.common.Order.Order;
import shoesShop.common.Order.OrderConverter;
import shoesShop.common.Order.OrderService;
import shoesShop.common.OrderLine.DbOrderLine;
import shoesShop.common.OrderLine.IOrderLineRepository;
import shoesShop.common.OrderLine.OrderLine;
import shoesShop.common.OrderLine.OrderLineConverter;
import shoesShop.common.OrderLine.OrderLineService;
import shoesShop.common.ProductVariationSizes.IProductVariationSizeRepository;
import shoesShop.common.User.User;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
	
	@Autowired
	private PaypalService paypalService;

	@Autowired
	private CartService cartService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private OrderLineService orderLineService;
	
	@Autowired
	private IOrderLineRepository orderLineRepository;
	
	@Autowired
	IColorRepository colorRepository;
	
	@Autowired
	IProductVariationSizeRepository pvsRepo;
	
	@Autowired
	IOrderRepository orderRepository;
	
	OrderConverter orderConverter = new OrderConverter();
	OrderLineConverter orderLineConverter =  new OrderLineConverter();
	
	public static final String SUCCESS_URL = "paypal/success";
	public static final String CANCEL_URL = "paypal/cancel";
	
	
	
	
	@PostMapping("/checkout")
	public ResponseEntity<String> processPayment(@RequestBody PaymentRequest paymentRequest, HttpServletRequest request) throws Exception {	
//		Double totalAmount = this.cartService.retriveCart(cart.getCartId()).getItemSubtotalPrice();
//		paymentRequest.getCart();

//		paymentRequest.setCart(paymentRequest.getCart());
//
		System.out.println(paymentRequest);
//		System.out.println(paymentRequest.cart);
//		System.out.println(paymentRequest.user);

		
		
		try {
	        Payment payment = paypalService.createPayment(
	        		paymentRequest.cart.getItemSubtotalPrice(), 
	        		paymentRequest.getCurrency(), 
	        		paymentRequest.getMethod(), 
	        		paymentRequest.getIntent(), 
	        		paymentRequest.getDescription(), 
	        		"http://localhost:8080/api/v1/payment/" + CANCEL_URL,
//	        		"http://localhost:5173/");
	        		"http://localhost:8080/api/v1/payment/" + SUCCESS_URL);
	        System.out.println(payment);
			for(Links link:payment.getLinks()) {
				if(link.getRel().equals("approval_url")) {
					
					
					System.out.println("vao trang thanh toan sandbox");
					Order order = orderService.createOrderFromCart(paymentRequest);
					System.out.println(order);
					Order savedOrder = orderService.create(order);
					System.out.println(savedOrder);
					
//					System.out.println(link.getHref());
					
//					Collection<OrderLine> orderLines = orderLineService.createOrderLinesFromCartItems(this.cartItemService.retrieveAll(paymentRequest.cart.getCartId()));
					Collection<OrderLine> orderLines = orderLineService.createOrderLinesFromCartItems(paymentRequest.cart.getCartItems());
					System.out.println(orderLines);  
		            Collection<DbOrderLine> savedDbOrderLines = orderLineService.createDbOrderLinesFromOrderLines(orderLines); 

		            System.out.println(savedDbOrderLines);
		                // chưa xóa được cartId khi thanh toán thành công, nên khi mua mới orderId sẽ bị ghi đè
//		                cartService.clear();
		            
//		            SUCCESS_URL =
		            
					return ResponseEntity.ok().body(link.getHref());
				}
			}
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		}
		System.out.print("cancel tu sandbox");
        return ResponseEntity.badRequest().body("Không tạo được thông tin thanh toán");
	}
	
	 @GetMapping(value = CANCEL_URL)
	    public ResponseEntity<String>cancelPay() {
		 System.out.print("cancel tu sandbox ===========");
		 return ResponseEntity.ok("Cancel");
	    }
	 
	 
	    @GetMapping(value = SUCCESS_URL)
	    public ResponseEntity<String> handlePaymentSuccess(@RequestBody PaymentRequest paymentRequest,
	    													@RequestParam("paymentId") String paymentId, 
	                                                       @RequestParam("token") String token, 
	                                                       @RequestParam("PayerID") String payerId) {
	        try {
	        	System.out.println("lỗi ==============");
	            Payment payment = paypalService.executePayment(paymentId, payerId);
	            System.out.println("lỗi tùm lum");
		        System.out.println(payment.toJSON());
		        System.out.flush();
		        
		        
		        System.out.println("vao trang thanh toan sandbox");
				Order order = orderService.createOrderFromCart(paymentRequest);
				System.out.println(order);
				Order savedOrder = orderService.create(order);
				System.out.println(savedOrder);
				
//				System.out.println(link.getHref());
				
				Collection<OrderLine> orderLines = orderLineService.createOrderLinesFromCartItems(this.cartItemService.retrieveAll(paymentRequest.cart.getCartId()));
//				Collection<OrderLine> orderLines = orderLineService.createOrderLinesFromCartItems(cart.getCartItems());
				System.out.println(orderLines);  
	            Collection<DbOrderLine> savedDbOrderLines = orderLineService.createDbOrderLinesFromOrderLines(orderLines); 

	            System.out.println(savedDbOrderLines);
		        
	            if (payment.getState().equals("approved")) {
	            	 System.out.println("heheheheheheheheheheheheh");
	            	 System.out.flush();
	                // Xử lý thành công thanh toán ở đây
	                // ...
	                return ResponseEntity.ok("Payment successful");
	            }
	        } catch (PayPalRESTException e) {
	        	 System.out.println("lỗi 1");
	        	 System.out.flush();
	            e.printStackTrace();
	        }
	        System.out.println("lỗi 2");
	        System.out.flush();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Payment failed");
	    }
	 

}
