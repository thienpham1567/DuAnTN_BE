package shoesShop.payment;


import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import shoesShop.common.Cart.Cart;
import shoesShop.common.Cart.CartService;
import shoesShop.common.CartItem.CartItem;
import shoesShop.common.CartItem.CartItemService;
import shoesShop.payment.PaypalService;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
	
	@Autowired
	private PaypalService paypalService;

	@PostMapping("/checkout")
	public ResponseEntity<String> processPayment(@RequestBody Cart cart) {
	    try {
	        Double totalAmount = cart.getItemSubtotalPrice();
	        String currency = "USD";
	        String method = "paypal";
	        String intent = "sale";
	        String description = "Thanh toán đơn hàng";
	        String cancelUrl = "https://www.google.com.vn/webhp";
	        String successUrl = "https://www.google.com.vn/webhp";

	        Payment payment = paypalService.createPayment(totalAmount, currency, method, intent, description, cancelUrl, successUrl);

	        if (payment.getState().equals("created")) {
	            String redirectUrl = payment.getLinks().stream()
	                    .filter(link -> link.getRel().equals("approval_url"))
	                    .findFirst()
	                    .orElseThrow(() -> new RuntimeException("Không tìm thấy URL chuyển hướng thanh toán"))
	                    .getHref();

	            // Chuyển hướng người dùng đến URL thanh toán PayPal
	            return ResponseEntity.ok().body(redirectUrl);
	        } else {
	            return ResponseEntity.badRequest().body("Không tạo được thông tin thanh toán");
	        }
	    } catch (PayPalRESTException e) {
	        e.printStackTrace();
	        return ResponseEntity.status(500).body("Lỗi trong quá trình xử lý thanh toán");
	    }
	}
}
