package shoesShop.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;

import shoesShop.common.Cart.CartService;
import shoesShop.common.CartItem.CartItem;

@RestController
@RequestMapping("api/v1/payment")
public class PaymentController {
	
	@Autowired
	private PaypalService paypalService;

	@Autowired
	private CartService cartService;
	
	@PostMapping("/checkout")
	public ResponseEntity<String> processPayment(@RequestBody CartItem cartId) {
	    try {
	        Double totalAmount = this.cartService.getSubTotalPrice(null);
	        String currency = "USD";
	        String method = "paypal";
	        String intent = "sale";
	        String description = "Thanh toán đơn hàng";
	        String cancelUrl = "https://www.google.com.vn/";
	        String successUrl = "https://www.google.com.vn/";

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
	        	// tạo 1 payload chứa các trường thông tin để trả về cho frontend
	        	System.out.print("cancel tu sandbox");
	            return ResponseEntity.badRequest().body("Không tạo được thông tin thanh toán");
	        }
	    } catch (PayPalRESTException e) {
	        e.printStackTrace();
	        System.out.print("cancel tu sandbox");
	        return ResponseEntity.status(500).body("Lỗi trong quá trình xử lý thanh toán");
	    }
	}
	
	 @GetMapping("/cancel/{cartId}")
	    public ResponseEntity<String> getCancelUrl(@PathVariable Long cartId) {
	        try {
	            String cancelUrl = "https://www.google.com.vn/webhp"; // Thay thế URL hủy thanh toán tại đây
	            return ResponseEntity.ok().body(cancelUrl);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body("Lỗi trong quá trình xử lý URL hủy thanh toán");
	        }
	    }
	 
	 @GetMapping("/success/{cartId}")
	    public ResponseEntity<String> getSuccessUrl(@PathVariable Long cartId) {
	        try {
	            String successUrl = "https://www.google.com.vn/webhp"; // Thay thế URL thành công tại đây
	            return ResponseEntity.ok().body(successUrl);
	        } catch (Exception e) {
	            e.printStackTrace();
	            return ResponseEntity.status(500).body("Lỗi trong quá trình xử lý URL thành công");
	        }
	    }
}
