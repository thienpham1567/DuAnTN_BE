package shoesShop.common.Cart;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.CartItem.DbCartItem;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Carts")
public class DbCart {
	@Id
	public String cartId;
	
	public Integer itemTotalQuantity;
	public Double itemSubtotalPrice;
	
	@OneToMany(mappedBy = "cart")
	Collection<DbCartItem> cartItems = new ArrayList<>();
}
