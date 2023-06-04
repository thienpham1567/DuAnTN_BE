package shoesShop.common.Cart;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.CartItem.DbCartItem;
import shoesShop.common.User.DbUser;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Carts")
public class DbCart {
	public DbCart(String cartId) {
		this.cartId = cartId;
	}
	@Id
	public String cartId;
	
	public Integer itemTotalQuantity;
	public Double itemSubtotalPrice;
	
	// ok
	@OneToMany(mappedBy = "cart")
	Collection<DbCartItem> cartItems = new ArrayList<>();
	
	// ok
	@ManyToOne
	@JoinColumn(name = "UserId")
	public DbUser user;
	
	// done
}
