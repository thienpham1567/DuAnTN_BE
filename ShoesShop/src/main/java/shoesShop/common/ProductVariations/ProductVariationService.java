package shoesShop.common.ProductVariations;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;

@Service
public class ProductVariationService extends RecordManager<ProductVariation> {
	@Autowired
	private IProductVariationRepository productVariationRepo;
	
	private ProductVariationConverter converter = new ProductVariationConverter();
	
	@Override
	public Collection<ProductVariation> retrieveAll() {
		Collection<ProductVariation> products = this.load(null).stream().map(dbProduct -> this.converter.convertDbToModel(dbProduct)).toList();
		return products;
	}

	@Override
	public ProductVariation retrieveOne(Integer id) {
		ProductVariation product = this.load(id).stream()
				.map(dbProduct -> this.converter.convertDbToModel(dbProduct)).findFirst().get();
		return product;
	}
	
	private Collection<DbProductVariation> load(Integer productVariationId) {
		Collection<DbProductVariation> dbProductVariations = this.productVariationRepo.findAll();

		if (productVariationId != null) {
			dbProductVariations = dbProductVariations.stream().filter(dbProductVariation -> dbProductVariation.productVariationId == productVariationId)
					.collect(Collectors.toList());
		}
		
		return dbProductVariations;
	}
}
