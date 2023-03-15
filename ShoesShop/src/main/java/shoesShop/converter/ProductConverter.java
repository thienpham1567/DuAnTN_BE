package shoesShop.converter;

import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import shoesShop.entity.DbOrderDetail;
import shoesShop.entity.DbProduct;
import shoesShop.model.Product;
import shoesShop.repository.IBrandRepository;
import shoesShop.repository.ICategoryRepository;
import shoesShop.repository.IOrderDetailRepository;

public class ProductConverter implements ICombiner<DbProduct>, IConverter<Product, DbProduct>{
	@Autowired
	private IBrandRepository brandRepo;
	
	@Autowired
	private ICategoryRepository categoryRepo;
	
	@Autowired
	private IOrderDetailRepository orderDetailRepo;
	
	@Override
	public void combine(DbProduct original, DbProduct update) {
		original.category = update.category;
		original.created = update.created;
		original.name = update.name;
		original.price = update.price;
		original.inStock = update.inStock;
		original.isAvailable = update.isAvailable;
	}

	@Override
	public DbProduct convertDbToModel(Product input) {
		return input == null ? null : new DbProduct(
					input.productId,
					input.name,
					input.imageLink,
					input.price,
					input.inStock,
					input.created,
					input.isAvailable,
					brandRepo.findById(input.brandId).get(),
					categoryRepo.findById(input.categoryId).get(),
					input.orderDetailIds.stream().map(id -> orderDetailRepo.findById(id).get()).collect(Collectors.toList())
				);
	}

	@Override
	public Product convertModelToDb(DbProduct input) {
		// TODO Auto-generated method stub
		return null;
	}
}