package shoesShop.common.ProductVariations;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Color.Color;
import shoesShop.common.Product.Product;
import shoesShop.common.ProductImage.ProductImage;
import shoesShop.common.ProductVariationSizes.ProductVariationSize;
import shoesShop.common.Review.Review;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariation {
	public ProductVariation(Integer productVariationId, Product product, Color color) {
		this.productVariationId = productVariationId;
		this.product = product;
		this.color = color;
	}
	
	public Integer productVariationId;
	public Product product;
	public Color color;
	public Collection<ProductVariationSize> productVariationSizes;
	public Collection<ProductImage> productImages;
	public Collection<Review> reviews;
}
