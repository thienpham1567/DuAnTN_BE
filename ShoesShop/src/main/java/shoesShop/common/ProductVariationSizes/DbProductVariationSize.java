package shoesShop.common.ProductVariationSizes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.CartItem.DbCartItem;
import shoesShop.common.OrderLine.DbOrderLine;
import shoesShop.common.ProductVariations.DbProductVariation;
import shoesShop.common.Size.DbSize;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ProductVariationSizes")
public class DbProductVariationSize implements Serializable{
 
	private static final long serialVersionUID = 1L;

	public DbProductVariationSize(Integer productVariationSizeId) {
		super();
		this.productVariationSizeId = productVariationSizeId;
	}
	
	

	public DbProductVariationSize(Integer productVariationSizeId, Integer quantity) {
		super();
		this.productVariationSizeId = productVariationSizeId;
		this.quantity = quantity;
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer productVariationSizeId;
	
	@OneToMany(mappedBy = "productVariationSize")
	Collection<DbOrderLine> orderLines = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "ProductVariationId")
	public DbProductVariation productVariation;
	
	@OneToMany(mappedBy = "productVariationSize")
	Collection<DbCartItem> cartItems = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "SizeId")
	public DbSize size;
	
	public Integer quantity;

}