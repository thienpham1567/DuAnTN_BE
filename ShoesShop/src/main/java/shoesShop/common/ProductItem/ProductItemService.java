package shoesShop.common.ProductItem;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.Product.IProductRepository;

@Service
public class ProductItemService extends RecordManager<ProductItem> {
	@Autowired
	IProductItemRepository productItemRepo;

	@Autowired
	IProductRepository productRepo;

	ProductItemConverter converter = new ProductItemConverter();

	@Override
	public Collection<ProductItem> retrieveAll() {
		Collection<ProductItem> productItems = this.load(null, null, null).stream()
				.map(dbProductItem -> this.converter.convertDbToModel(dbProductItem)).collect(Collectors.toList());
		return productItems;
	}

	@Override
	public ProductItem retrieveOne(Integer id) {
		ProductItem productItem = this.load(id, null, null).stream()
				.map(dbProductItem -> this.converter.convertDbToModel(dbProductItem)).findFirst().get();
		return productItem;
	}
	
	public Collection<ProductItem> retrieveAll(Integer brandId, Integer categoryId) {
		Collection<ProductItem> productItems = this.load(null, brandId, categoryId).stream()
				.map(dbProductItem -> this.converter.convertDbToModel(dbProductItem)).collect(Collectors.toList());
		return productItems;
	}

	private Collection<DbProductItem> load(Integer productId, Integer brandId, Integer categoryId) {
		Collection<DbProductItem> dbProductItems = this.productItemRepo.findAll();

		if (productId != null) {
			dbProductItems = dbProductItems.stream()
					.filter(dbProductItem -> dbProductItem.product.productId == productId).collect(Collectors.toList());
		}

		if (brandId != null && categoryId != null) {
			return dbProductItems = dbProductItems.stream()
					.filter(dbProductItem -> dbProductItem.product.brand.brandId == brandId
							&& dbProductItem.product.category.categoryId == categoryId)
					.collect(Collectors.toList());
		}

		if (brandId != null) {
			dbProductItems = dbProductItems.stream()
					.filter(dbProductItem -> dbProductItem.product.brand.brandId == brandId)
					.collect(Collectors.toList());
		}

		if (categoryId != null) {
			dbProductItems = dbProductItems.stream()
					.filter(dbProductItem -> dbProductItem.product.category.categoryId == categoryId)
					.collect(Collectors.toList());
		}

		return dbProductItems;
	}
}
