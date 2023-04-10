package shoesShop.common.Cart;

import java.util.ArrayList;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
	public String cartId;
	
	public Integer itemTotalQuantity;
	public Double itemSubtotalPrice;
	
	Collection<Integer> cartItemIds = new ArrayList<>();
}
