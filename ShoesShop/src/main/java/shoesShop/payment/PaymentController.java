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
	private OrderService orderService;

	@Autowired
	private OrderLineService orderLineService;

	@Autowired
	IColorRepository colorRepository;

	@Autowired
	IProductVariationSizeRepository pvsRepo;

	@Autowired
	IOrderRepository orderRepository;

	OrderConverter orderConverter = new OrderConverter();
	OrderLineConverter orderLineConverter = new OrderLineConverter();

	public static final String SUCCESS_URL = "paypal/success";
	public static final String CANCEL_URL = "paypal/cancel";

	PaymentRequest data;

	@PostMapping("/checkout")
	public ResponseEntity<String> processPayment(@RequestBody PaymentRequest paymentRequest) throws Exception {
		try {
			Payment payment = paypalService.createPayment(paymentRequest.cart.getItemSubtotalPrice(),
					paymentRequest.getCurrency(), paymentRequest.getMethod(), paymentRequest.getIntent(),
					paymentRequest.getDescription(), "http://localhost:8080/api/v1/payment/" + CANCEL_URL,
					"http://localhost:8080/api/v1/payment/" + SUCCESS_URL);
			for (Links link : payment.getLinks()) {
				if (link.getRel().equals("approval_url")) {

					data = paymentRequest;

					return ResponseEntity.ok().body(link.getHref());
				}
			}
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		}
		return ResponseEntity.badRequest().body("Không tạo được thông tin thanh toán");
	}

	@GetMapping(value = CANCEL_URL)
	public ResponseEntity<String> cancelPay() {
		String redirectScript = "<script>window.location.href = 'http://localhost:5173/cart';</script>";
		return ResponseEntity.ok().body(redirectScript);
	}

	@GetMapping(value = SUCCESS_URL)
	public ResponseEntity<String> handlePaymentSuccess(@RequestParam("paymentId") String paymentId,
			@RequestParam("token") String token, @RequestParam("PayerID") String payerId) {
		try {
			Payment payment = paypalService.executePayment(paymentId, payerId);
			System.out.println(payment.toJSON());

			if (payment.getState().equals("approved")) {
				// Xử lý thành công thanh toán ở đây
				
				// xử lí lưu Order => DbOrder
				Order order = orderService.createOrderFromCart(data);
				Order savedOrder = orderService.create(order);
				
				// xử lí lưu các OrderLine của Order
				Collection<OrderLine> orderLines = orderLineService
						.createOrderLinesFromCartItems(data.cart.getCartItems());
				Collection<DbOrderLine> savedDbOrderLines = orderLineService
						.createDbOrderLinesFromOrderLines(orderLines);
	
				// chuyển đến frontend 
				String redirectScript = "<script>window.location.href = 'http://localhost:5173/payment/paypal/success';</script>";
				return ResponseEntity.ok().body(redirectScript);
			}
		} catch (PayPalRESTException e) {
			e.printStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(CANCEL_URL);
	}

}
