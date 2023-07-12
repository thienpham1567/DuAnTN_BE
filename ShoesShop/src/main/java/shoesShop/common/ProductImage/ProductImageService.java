package shoesShop.common.ProductImage;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;

@Service
public class ProductImageService extends RecordManager<ProductImage>{
	
	@Autowired
	IProductImageRepository productImageRepo;
	
	ProductImageConverter converter = new ProductImageConverter();
	
	@Override
	public Collection<ProductImage> retrieveAll() {
		Collection<ProductImage> productImages = this.load(null, null).stream()
				.map(dbProductImage -> this.converter.convertDbToModel(dbProductImage)).collect(Collectors.toList());
		return productImages;
	}
	
	private Collection<DbProductImage> load(Integer productImageId, Integer productVariationId) {
		Collection<DbProductImage> dbProductImages = this.productImageRepo.findAll();

		if (productImageId != null) {
			dbProductImages = dbProductImages.stream()
					.filter(dbProductImage -> dbProductImage.productImageld == productImageId)
					.collect(Collectors.toList());
		}
		
		if (productVariationId != null) {
			dbProductImages = dbProductImages.stream()
					.filter(dbProductVariationSize -> dbProductVariationSize.productVariation.productVariationId == productVariationId)
					.collect(Collectors.toList());
		}

		return dbProductImages;
	}
}
