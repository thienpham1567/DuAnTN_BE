package shoesShop.common.ProductVariationSizes;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.ProductVariations.IProductVariationRepository;
import shoesShop.common.Size.ISizeRepository;

@Service
public class ProductVariationSizeService extends RecordManager<ProductVariationSize>{
	@Autowired
	IProductVariationSizeRepository productVariationSizeRepo;
	
	ProductVariationSizeConverter converter = new ProductVariationSizeConverter();
	
	@Autowired
	ISizeRepository sizeRepo;
	
	@Autowired
	IProductVariationRepository productVariationRepo;
	
	@Override
	public Collection<ProductVariationSize> retrieveAll() {
		Collection<ProductVariationSize> productVariationSizes = this.load(null, null, null).stream()
				.map(dbProductVariationSize -> this.converter.convertDbToModel(dbProductVariationSize)).collect(Collectors.toList());
		return productVariationSizes;
	}
	
	/*--Insert productVariationSize in Admin page--*/
	@Override
	public ProductVariationSize create(ProductVariationSize productVariationSize) {
		DbProductVariationSize dbProductVariationSize = this.converter.convertModelToDb(productVariationSize);
		dbProductVariationSize.size = this.sizeRepo.findById(productVariationSize.size.sizeId).get();
		dbProductVariationSize.productVariation = this.productVariationRepo.findById(productVariationSize.productVariation.productVariationId).get();
		DbProductVariationSize createdProductVariationSize = this.productVariationSizeRepo.save(dbProductVariationSize);
		return this.converter.convertDbToModel(createdProductVariationSize);
	}
	
	/*--Update product in Admin page--*/
	@Override
	public ProductVariationSize update(ProductVariationSize productVariationSize, Integer id) {
		DbProductVariationSize updateProductVariationSize = this.converter.convertModelToDb(productVariationSize);
		updateProductVariationSize.productVariation = this.productVariationRepo.findById(productVariationSize.productVariation.productVariationId).get();
		updateProductVariationSize.size = this.sizeRepo.findById(productVariationSize.size.sizeId).get();

		DbProductVariationSize dbProductVariationSize = this.productVariationSizeRepo.findById(id).get();
		if (dbProductVariationSize != null) {
			this.converter.combine(dbProductVariationSize, updateProductVariationSize);
			DbProductVariationSize updateDbProductVariationSize = this.productVariationSizeRepo.save(dbProductVariationSize);
			return this.converter.convertDbToModel(updateDbProductVariationSize);
		}

		return null;
	}
	
	/*--Delete productVariationSize in Admin page--*/
	@Override
	public Boolean delete(Integer id) {
		if(productVariationSizeRepo.existsById(id)) {
			System.out.println("true");
			this.productVariationSizeRepo.deleteById(id);
			return true;
		}
		System.out.println("false");
		return false;
	}
	
	private Collection<DbProductVariationSize> load(Integer productVariationSizeId, Integer productVariationId, Integer sizeId) {
		Collection<DbProductVariationSize> dbProductVariationSizes = this.productVariationSizeRepo.findAll();

		if (productVariationSizeId != null) {
			dbProductVariationSizes = dbProductVariationSizes.stream()
					.filter(dbProductVariationSize -> dbProductVariationSize.productVariationSizeId == productVariationSizeId)
					.collect(Collectors.toList());
		}
		
		if (productVariationId != null) {
			dbProductVariationSizes = dbProductVariationSizes.stream()
					.filter(dbProductVariationSize -> dbProductVariationSize.productVariation.productVariationId == productVariationId)
					.collect(Collectors.toList());
		}
		
		if(sizeId != null) {
			dbProductVariationSizes = dbProductVariationSizes.stream()
					.filter(dbProductVariationSize -> dbProductVariationSize.size.sizeId == sizeId)
					.collect(Collectors.toList());
		}

		return dbProductVariationSizes;
	}
}