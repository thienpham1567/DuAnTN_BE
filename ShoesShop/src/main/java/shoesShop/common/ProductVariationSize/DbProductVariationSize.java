package shoesShop.common.ProductVariationSize;

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
@Table(name = "DbProductVariationSizes")
public class DbProductVariationSize implements Serializable{
 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer productVariationSizeId;
	
	// ok
	@OneToMany(mappedBy = "ProductVariationSize")
	Collection<DbOrderLine> orderLines = new ArrayList<>();
	
	// ok
	@ManyToOne
	@JoinColumn(name = "ProductVariationId")
	public DbProductVariation productVariation;
	
	// ok
	@OneToMany(mappedBy = "ProductVariationSize")
	Collection<DbCartItem> cartItems = new ArrayList<>();
	
	// ok
	@ManyToOne
	@JoinColumn(name = "SizeId")
	public DbSize size;
	
	public Integer qunatity;
	
	// done
}
