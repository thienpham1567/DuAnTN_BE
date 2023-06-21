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
//	public ProductVariation productVariation;
	public Size size;
//	public Collection<OrderLine> orderLines = new ArrayList<>();
//	public Collection<CartItem> cartItems = new ArrayList<>();
}
