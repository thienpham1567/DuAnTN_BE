package shoesShop.common.CartItem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Cart.DbCart;
import shoesShop.common.ProductItem.DbProductItem;
import shoesShop.common.ProductVariationSize.DbProductVariationSize;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CartItems")
public class DbCartItem {
	public DbCartItem(Double price, Integer quantity) {
		super();
		this.price = price;
		this.quantity = quantity;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer cartItemId;
	
	public Double price;
	public Integer quantity;
		
	// ok
	@ManyToOne
	@JoinColumn(name = "CartId")
	public DbCart cart;
	
	// ok
	@ManyToOne
	@JoinColumn(name = "ProductVariationSizeId")
	public DbProductVariationSize productVariationSize;

	// done
}
