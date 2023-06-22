package shoesShop.common.Product;

import java.time.LocalDateTime;
import java.util.Collection;

import shoesShop.common.Brand.DbBrand;
import shoesShop.common.Category.DbCategory;
import shoesShop.common.ProductVariationSizes.DbProductVariationSize;
import shoesShop.common.ProductVariations.DbProductVariation;

public class ProductDTO {
	public Integer productId;
	public String name;
	public Double price;
	public String sku;
	public String description;
	public LocalDateTime createdAt;
	public LocalDateTime updatedAt;
	public Collection<DbBrand> brand;
	public Collection<DbCategory> category;
	public Collection<DbProductVariation> productVariations;
	public Collection<DbProductVariationSize> productVariationSize;
}
