package shoesShop.common.ProductImage;

import java.io.Serializable;

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
import shoesShop.common.ProductVariations.DbProductVariation;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ProductImage")
public class DbProductImage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	public DbProductImage(String imageUrl, Boolean isPrimary) {
		super();
		this.imageUrl = imageUrl;
		this.isPrimary = isPrimary;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer productImageld;
	
	// ok
	@ManyToOne
	@JoinColumn(name = "ProductVariationId")
	public DbProductVariation productVariation;
	
	public String imageUrl;
	
	public Boolean isPrimary;
	
	// done
}
