package shoesShop.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Cart.Cart;
import shoesShop.common.User.User;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
	public PaymentRequest(Integer paymentRequestId, String denormalizedAddress, Cart cart,Integer userId) {
		this.paymentRequestId = paymentRequestId;
		this.denormalizedAddress = denormalizedAddress;
		this.cart = cart;
		this.userId = userId;
	}
	public Integer paymentRequestId;
	public String denormalizedAddress;
	public Cart cart;
	public Integer userId;
	private String currency = "USD";
	private String method = "paypal";
	private String intent = "sale";
	private String description = "testpayy";
}
