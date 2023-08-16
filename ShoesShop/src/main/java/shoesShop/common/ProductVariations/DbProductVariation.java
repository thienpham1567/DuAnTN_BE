package shoesShop.common.ProductVariations;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Color.DbColor;
import shoesShop.common.Favorite.DbFavorite;
import shoesShop.common.Product.DbProduct;
import shoesShop.common.ProductImage.DbProductImage;
import shoesShop.common.ProductVariationSizes.DbProductVariationSize;
import shoesShop.common.Review.DbReview;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ProductVariations")
public class DbProductVariation implements Serializable{
	private static final long serialVersionUID = 1L;

	

	public DbProductVariation(Integer productVariationId) {
		super();
		this.productVariationId = productVariationId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer productVariationId;
	
	@ManyToOne
	@JoinColumn(name = "ProductId")
	public DbProduct product;
	
	@ManyToOne
	@JoinColumn(name = "ColorId")
	public DbColor color;
	
	@OneToMany(mappedBy = "productVariation")
	Collection<DbProductVariationSize> productVariationSizes = new ArrayList<>();

	@OneToMany(mappedBy = "productVariation")
	Collection<DbProductImage> productImages = new ArrayList<>();
	
	@OneToMany(mappedBy = "productVariation")
	Collection<DbReview> reviews = new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "productVariation")
	Collection<DbFavorite> favorites = new ArrayList<>();
}
