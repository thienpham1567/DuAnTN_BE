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
import shoesShop.common.Color.DbColor;
import shoesShop.common.Product.DbProduct;
import shoesShop.common.ProductVariationSizes.DbProductVariationSize;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CartItems")
public class DbCartItem {
	public DbCartItem(String cartId, Double price, Integer quantity, DbProduct product,
			DbColor color, DbProductVariationSize pvs) {
		this.cart.cartId = cartId;
		this.price = price;
		this.quantity = quantity;
		this.product = product;
		this.color = color;
		this.productVariationSize = pvs;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer cartItemId;
	
	public Double price;
	public Integer quantity;
	public String imageUrl;
		
	@ManyToOne
	@JoinColumn(name = "CartId")
	public DbCart cart;
	
	@ManyToOne
	@JoinColumn(name = "ProductId")
	public DbProduct product;
	
	@ManyToOne
	@JoinColumn(name = "ColorId")
	public DbColor color;
	
	@ManyToOne
	@JoinColumn(name = "ProductVariationSizeId")
	public DbProductVariationSize productVariationSize;
}
