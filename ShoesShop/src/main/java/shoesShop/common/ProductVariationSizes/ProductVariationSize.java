package shoesShop.common.ProductVariationSizes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.ProductVariations.ProductVariation;
import shoesShop.common.Size.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariationSize {
	public Integer productVariationSizeId;
	public Integer quantity;
	public Size size;
	public ProductVariation productVariation;
}