package shoesShop.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.converter.ProductConverter;
import shoesShop.entity.DbProduct;
import shoesShop.model.Product;
import shoesShop.repository.IBrandRepository;
import shoesShop.repository.ICategoryRepository;
import shoesShop.repository.IProductRepository;

@Service
public class ProductService extends RecordManager<Product>{
	@Autowired
	private IProductRepository productRepo;
	
	@Autowired
	private IBrandRepository brandRepo;
	
	@Autowired
	private ICategoryRepository categoryRepo;
	
	ProductConverter converter = new ProductConverter();
	
	@Override
	public Collection<Product> retrieveAll(){
		Collection<Product> products = this.load(null, null, null).stream().map(dbProduct -> this.converter.convertDbToModel(dbProduct)).collect(Collectors.toList());
		return products;
	}
	
	@Override
	public Product retrieveOne(Integer id){
		Product product = this.load(id, null, null).stream().map(dbProduct -> this.converter.convertDbToModel(dbProduct)).findFirst().get();
		return product;
	}
	
	@Override
	public Product create(Product product) {
		DbProduct dbProduct = this.converter.convertModelToDb(product);
		dbProduct.brand = this.brandRepo.findById(product.brandId).get();
		dbProduct.category =  this.categoryRepo.findById(product.categoryId).get();
		DbProduct createdProduct = this.productRepo.save(dbProduct);
		return this.converter.convertDbToModel(createdProduct);
	}
	
	@Override
	public Product update(Product product, Integer id) {
		DbProduct updateProduct = this.converter.convertModelToDb(product);
		updateProduct.brand = this.brandRepo.findById(product.brandId).get();
		updateProduct.category =  this.categoryRepo.findById(product.categoryId).get();
		
		DbProduct dbProduct = this.productRepo.findById(id).get();
		if(dbProduct != null) {
			this.converter.combine(dbProduct, updateProduct);
			DbProduct updateDbProduct = this.productRepo.save(dbProduct);
			return this.converter.convertDbToModel(updateDbProduct);
		}
		
		return null;
	}
	@Override
	public Boolean delete(Integer id) {
		if(this.productRepo.existsById(id)) {
			this.productRepo.deleteById(id);
			return true;
		}
		
		return false;
	}
	
	private Collection<DbProduct> load(Integer productId, Integer brandId, Integer categoryId){
		Collection<DbProduct> dbProducts = this.productRepo.findAll();
		
		if(productId != null) {
			dbProducts = dbProducts.stream().filter(dbProduct -> dbProduct.productId == productId).collect(Collectors.toList());
		}
		
		if(brandId != null) {
			dbProducts = dbProducts.stream().filter(dbProduct -> dbProduct.brand.brandId == brandId).collect(Collectors.toList());
		}

		if(categoryId != null) {
			dbProducts = dbProducts.stream().filter(dbProduct -> dbProduct.category.categoryId == categoryId).collect(Collectors.toList());
		}
		
		return dbProducts;
	}
}
