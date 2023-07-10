package shoesShop.common.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.Brand.IBrandRepository;
import shoesShop.common.Category.ICategoryRepository;
import shoesShop.common.ProductVariations.IProductVariationRepository;

@Service
public class ProductService extends RecordManager<Product> {
	@Autowired
	private IProductRepository productRepo;

	@Autowired
	private IBrandRepository brandRepo;

	@Autowired
	private ICategoryRepository categoryRepo;
	
	@Autowired
	private IProductVariationRepository productVariationRepo;

	ProductConverter converter = new ProductConverter();

	@Override
	public Collection<Product> retrieveAll() {
		Collection<Product> products = this.load(null, null, null).stream()
				.map(dbProduct -> this.converter.convertDbToModel(dbProduct)).collect(Collectors.toList());
		return products;
	}

	@Override
	public Product retrieveOne(Integer id) {
		Product product = this.load(id, null, null).stream()
				.map(dbProduct -> this.converter.convertDbToModel(dbProduct)).findFirst().get();
		return product;
	}

	/*--Insert product--*/
	@Override
	public Product create(Product product) {
		DbProduct dbProduct = this.converter.convertModelToDb(product);
		dbProduct.createdAt = LocalDateTime.now();
		dbProduct.brand = this.brandRepo.findById(product.brand.brandId).get();
		dbProduct.category = this.categoryRepo.findById(product.category.categoryId).get();
		DbProduct createdProduct = this.productRepo.save(dbProduct);
		return this.converter.convertDbToModel(createdProduct);
	}

	/*--Update product in Admin page--*/
	@Override
	public Product update(Product product, Integer id) {
		DbProduct updateProduct = this.converter.convertModelToDb(product);
		updateProduct.brand = this.brandRepo.findById(product.brand.brandId).get();
		updateProduct.category = this.categoryRepo.findById(product.category.categoryId).get();
		updateProduct.updatedAt = LocalDateTime.now();

		DbProduct dbProduct = this.productRepo.findById(id).get();
		if (dbProduct != null) {
			this.converter.combine(dbProduct, updateProduct);
			DbProduct updateDbProduct = this.productRepo.save(dbProduct);
			return this.converter.convertDbToModel(updateDbProduct);
		}

		return null;
	}

	/*--Delete product in Admin page--*/
	@Override
	public Boolean delete(Integer id) {
		if (productRepo.existsById(id)) {
			this.productRepo.deleteById(id);
			return true;
		}

		return false;
	}

	public Collection<Product> retrieveAll(Integer brandId, Integer categoryId) {
		Collection<Product> products = this.load(null, null, null).stream()
				.map(dbProduct -> this.converter.convertDbToModel(dbProduct)).collect(Collectors.toList());
		return products;
	}
	
	public Collection<Product> findByKeyword(String name) {
		Collection<DbProduct> dbProducts = productRepo.findByKeyword(name);
		Collection<Product> Products = new ArrayList<>(); 

	    for (DbProduct dbProduct : dbProducts) {
	        Product product = this.converter.convertDbToModel(dbProduct);
	        Products.add(product);
	    }
	    return Products;
	}

	private Collection<DbProduct> load(Integer productId, Integer brandId, Integer categoryId) {
		Collection<DbProduct> dbProducts = this.productRepo.findAll();

		if (productId != null) {
			dbProducts = dbProducts.stream().filter(dbProduct -> dbProduct.productId == productId)
					.collect(Collectors.toList());
		}

		if (brandId != null && categoryId != null) {
			return dbProducts = dbProducts.stream().filter(
					dbProduct -> dbProduct.brand.brandId == brandId && dbProduct.category.categoryId == categoryId)
					.collect(Collectors.toList());
		}

		if (brandId != null) {
			dbProducts = dbProducts.stream().filter(dbProduct -> dbProduct.brand.brandId == brandId)
					.collect(Collectors.toList());
		}

		if (categoryId != null) {
			dbProducts = dbProducts.stream().filter(dbProduct -> dbProduct.category.categoryId == categoryId)
					.collect(Collectors.toList());
		}

		return dbProducts;
	}
}
