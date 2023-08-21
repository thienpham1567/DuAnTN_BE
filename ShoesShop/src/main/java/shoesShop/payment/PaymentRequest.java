package shoesShop.payment;

import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Cart.Cart;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
	public PaymentRequest(Integer paymentRequestId, Integer addressId, Cart cart, Integer userId) {
		this.paymentRequestId = paymentRequestId;
		this.addressId = addressId;
		this.cart = cart;
		this.userId = userId;
	}
	public Integer userId;
	public Integer paymentRequestId;
	public Integer addressId;
	public Cart cart;
	private String currency = "USD";
	private String method = "paypal";
	private String intent = "sale";
	private String description = "testpayy";
}
