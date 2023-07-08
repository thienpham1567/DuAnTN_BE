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
	public DbCartItem(Double price, Integer quantity, String imageUrl) {
		this.price = price;
		this.quantity = quantity;
		this.imageUrl = imageUrl;
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
	@JoinColumn(name = "ProductVariationSizeId")
	public DbProductVariationSize productVariationSize;
	
	@ManyToOne
	@JoinColumn(name = "ColorId")
	public DbColor color;
}
