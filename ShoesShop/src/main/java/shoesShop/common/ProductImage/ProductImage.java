package shoesShop.common.ProductImage;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.ProductVariations.ProductVariation;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductImage {
	public Integer productImageId;
	public String imageUrl;
	public Boolean isPrimary;
//	public ProductVariation productVariation;
}
