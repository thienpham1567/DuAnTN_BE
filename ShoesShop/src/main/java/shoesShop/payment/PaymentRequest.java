package shoesShop.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Cart.Cart;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
	public PaymentRequest(Integer paymentRequestId, Integer addressId, Cart cart) {
		this.paymentRequestId = paymentRequestId;
		this.addressId = addressId;
		this.cart = cart;
	}
	public Integer paymentRequestId;
	public Integer addressId;
	public Cart cart;
	private String currency = "USD";
	private String method = "paypal";
	private String intent = "sale";
	private String description = "testpayy";
}
