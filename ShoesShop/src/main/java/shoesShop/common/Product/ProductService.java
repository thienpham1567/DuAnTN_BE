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
import shoesShop.common.ProductDetails.ProductDTO;


@Service
public class ProductService extends RecordManager<Product> {
	@Autowired
	private IProductRepository productRepo;

	@Autowired
	private IBrandRepository brandRepo;

	@Autowired
	private ICategoryRepository categoryRepo;


	ProductConverter converter = new ProductConverter();
	
	/*--Get all products--*/
	public Collection<ProductDTO> getAll() {
		return productRepo.getAll();
	}
	
	/*--Get product detail--*/
	public Collection<ProductDTO> getProductDetails(Integer id) {
        return productRepo.getProductDetails(id);
    }
	
	
	/*--Search product by product name--*/
	public Collection<Product> searchProductsByName(String name) {
		Collection<DbProduct> dbProducts = productRepo.searchProductsByName(name);
		Collection<Product> products = new ArrayList<>(); 
		
		for (DbProduct dbProduct : dbProducts) {
			Product product = this.converter.convertDbToModel(dbProduct);
			products.add(product);
		}
		return products;
	}
	
	/*--Filter: get all products by brand id--*/
	@Override
	public Collection<Product> retrieveAllProductsByBrandId(Integer id){
		Collection<Product> products = this.load(null, id, null).stream()
				.map(dbProduct -> this.converter.convertDbToModel(dbProduct)).collect(Collectors.toList());
		return products;
	}
	
	/*--Filter: get all products by category id--*/
	@Override
	public Collection<Product> retrieveAllProductsByCategoryId(Integer id){
		Collection<Product> products = this.load(null, null, id).stream()
				.map(dbProduct -> this.converter.convertDbToModel(dbProduct)).collect(Collectors.toList());
		return products;
	}

//	public DbProduct getProductDetails(Integer id) {
//		Product product = this.load(id, null, null).stream()
//				.map(dbProduct -> this.converter.convertDbToModel(dbProduct)).findFirst().get();
//		return product;
//	}

	@Override
	public Product create(Product product) {
		DbProduct dbProduct = this.converter.convertModelToDb(product);
		dbProduct.createdAt = LocalDateTime.now();
		dbProduct.brand = this.brandRepo.findById(product.brandId).get();
		dbProduct.category = this.categoryRepo.findById(product.categoryId).get();
		DbProduct createdProduct = this.productRepo.save(dbProduct);
		return this.converter.convertDbToModel(createdProduct);
	}

	@Override
	public Product update(Product product, Integer id) {
		DbProduct updateProduct = this.converter.convertModelToDb(product);
		updateProduct.brand = this.brandRepo.findById(product.brandId).get();
		updateProduct.category = this.categoryRepo.findById(product.categoryId).get();

		DbProduct dbProduct = this.productRepo.findById(id).get();
		if (dbProduct != null) {
			this.converter.combine(dbProduct, updateProduct);
			DbProduct updateDbProduct = this.productRepo.save(dbProduct);
			return this.converter.convertDbToModel(updateDbProduct);
		}

		return null;
	}

	@Override
	public Boolean delete(Integer id) {
		if (this.productRepo.existsById(id)) {
			this.productRepo.deleteById(id);
			return true;
		}

		return false;
	}

//	public Collection<Product> retrieveAll(Integer brandId, Integer categoryId) {
//		Collection<Product> products = this.load(null, null, null).stream()
//				.map(dbProduct -> this.converter.convertDbToModel(dbProduct)).collect(Collectors.toList());
//		return products;
//	}
	

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

//	@Override
//	public Collection<Product> retrieveAll(Integer id) throws Exception {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
}
