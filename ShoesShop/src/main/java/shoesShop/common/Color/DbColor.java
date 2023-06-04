package shoesShop.common.Color;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Product.DbProduct;
import shoesShop.common.ProductVariations.DbProductVariation;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Colors")
public class DbColor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer colorId;
	
	public String value;
	
	// ok
	@OneToMany(mappedBy = "color")
	Collection<DbProductVariation> productVariations = new ArrayList<>();


	// done
}
