package shoesShop.common.ProductImage;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.ProductVariationSizes.DbProductVariationSize;
import shoesShop.common.ProductVariationSizes.ProductVariationSize;
import shoesShop.common.ProductVariations.IProductVariationRepository;

@Service
public class ProductImageService extends RecordManager<ProductImage>{
	
	@Autowired
	IProductImageRepository productImageRepo;
	
	@Autowired
	IProductVariationRepository productVariationRepo;
	
	ProductImageConverter converter = new ProductImageConverter();
	
	/*--Get all productImage in Admin page--*/
	@Override
	public Collection<ProductImage> retrieveAll() {
		Collection<ProductImage> productImages = this.load(null, null).stream()
				.map(dbProductImage -> this.converter.convertDbToModel(dbProductImage)).collect(Collectors.toList());
		return productImages;
	}
	
	/*--Insert productImage in Admin page--*/
	@Override
	public ProductImage create(ProductImage productImage) {
		System.out.println(productImage.imageUrl);
		System.out.println(productImage.isPrimary);
		DbProductImage dbProductImage = this.converter.convertModelToDb(productImage);
		System.out.println(dbProductImage.imageUrl);
		System.out.println(dbProductImage.isPrimary);
		dbProductImage.productVariation = this.productVariationRepo.findById(productImage.productVariation.productVariationId).get();
		DbProductImage createdProductImage = this.productImageRepo.save(dbProductImage);
		return this.converter.convertDbToModel(createdProductImage);
	}
	
	/*--Update productImage in Admin page--*/
	@Override
	public ProductImage update(ProductImage productImage, Integer id) {
		DbProductImage updateProductImage = this.converter.convertModelToDb(productImage);
		updateProductImage.productVariation = this.productVariationRepo.findById(productImage.productVariation.productVariationId).get();

		DbProductImage dbProductImage = this.productImageRepo.findById(id).get();
		if (dbProductImage != null) {
			this.converter.combine(dbProductImage, updateProductImage);
			DbProductImage updateDbProductImage = this.productImageRepo.save(dbProductImage);
			return this.converter.convertDbToModel(updateDbProductImage);
		}

		return null;
	}
	
	/*--Delete productImage in Admin page--*/
	@Override
	public Boolean delete(Integer id) {
		if (productImageRepo.existsById(id)) {
			this.productImageRepo.deleteById(id);
			return true;
		}

		return false;
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
