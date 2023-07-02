package shoesShop.common.ProductVariations;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Color.Color;
import shoesShop.common.Product.Product;
import shoesShop.common.ProductImage.ProductImage;
import shoesShop.common.ProductVariationSizes.ProductVariationSize;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariation {
	public Integer productVariationId;
	public Product product;
	public Color color;
	public Collection<ProductVariationSize> productVariationSizes;
	public Collection<ProductImage> productImages;
}
