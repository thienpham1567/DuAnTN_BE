package shoesShop.common.ProductVariations;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.Color.IColorRepository;
import shoesShop.common.Product.DbProduct;
import shoesShop.common.Product.IProductRepository;
import shoesShop.common.Product.Product;

@Service
public class ProductVariationService extends RecordManager<ProductVariation> {
	@Autowired
	private IProductVariationRepository productVariationRepo;

	private ProductVariationConverter converter = new ProductVariationConverter();

	@Override
	public Collection<ProductVariation> retrieveAll() {
		Collection<ProductVariation> products = this.load(null, null, null, null).stream()
				.map(dbProduct -> this.converter.convertDbToModel(dbProduct)).collect(Collectors.toList());
		return products;
	}

	public Collection<ProductVariation> retrieveAll(Integer brandId, Integer categoryId) {
		Collection<ProductVariation> products = this.load(null, null, brandId, categoryId).stream()
				.map(dbProduct -> this.converter.convertDbToModel(dbProduct)).collect(Collectors.toList());
		return products;
	}
	
	/*--Insert productVariation in Admin page--*/
	@Override
	public ProductVariation create(ProductVariation productVariation) {
		DbProductVariation dbProductVariation = this.converter.convertModelToDb(productVariation);
		dbProductVariation.color = this.colorRepo.findById(productVariation.color.colorId).get();
		dbProductVariation.product = this.productRepo.findById(productVariation.product.productId).get();
		DbProductVariation createdProductVariation = this.productVariationRepo.save(dbProductVariation);
		return this.converter.convertDbToModel(createdProductVariation);
	}
	
	/*--Delete productVariation in Admin page--*/
	@Override
	public Boolean delete(Integer id) {
		if (productVariationRepo.existsById(id)) {
			this.productVariationRepo.deleteById(id);
			return true;
		}

		return false;
	}

	@Override
	public ProductVariation retrieveOne(Integer id) {
		ProductVariation product = this.load(id, null, null, null).stream()
				.map(dbProduct -> this.converter.convertDbToModel(dbProduct)).findFirst().get();
		return product;
	}
	
	public Collection<ProductVariation> retrieveProduct(Integer id) {
		Collection<ProductVariation> products = this.load(null, id, null, null).stream()
				.map(dbProduct -> this.converter.convertDbToModel(dbProduct)).collect(Collectors.toList());;
		return products;
	}

	private Collection<DbProductVariation> load(Integer productVariationId, Integer productId, Integer brandId, Integer categoryId) {
		Collection<DbProductVariation> dbProductVariations = this.productVariationRepo.findAll();

		if (productVariationId != null) {
			dbProductVariations = dbProductVariations.stream()
					.filter(dbProductVariation -> dbProductVariation.productVariationId == productVariationId)
					.collect(Collectors.toList());
		}
		
		if (productId != null) {
			dbProductVariations = dbProductVariations.stream()
					.filter(dbProductVariation -> dbProductVariation.product.productId == productId)
					.collect(Collectors.toList());
		}

		if (brandId != null && categoryId != null) {
			dbProductVariations = dbProductVariations.stream()
					.filter(dbProductVariation -> dbProductVariation.product.brand.brandId == brandId
							&& dbProductVariation.product.category.categoryId == categoryId)
					.collect(Collectors.toList());
		}
		if (brandId != null) {
			dbProductVariations = dbProductVariations.stream()
					.filter(dbProductVariation -> dbProductVariation.product.brand.brandId == brandId)
					.collect(Collectors.toList());
		}
		if (categoryId != null) {
			dbProductVariations = dbProductVariations.stream()
					.filter(dbProductVariation -> dbProductVariation.product.category.categoryId == categoryId)
					.collect(Collectors.toList());
		}

		return dbProductVariations;
	}
}
