package shoesShop.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.entity.DbProduct;
import shoesShop.repository.IProductRepository;

@Service
public class ProductService extends RecordManager<DbProduct>{
	@Autowired
	private IProductRepository productRepo;
	
	@Override
	public List<DbProduct> getAll(){
		return productRepo.findAll();
	}
	
	@Override
	public DbProduct getOne(int id){
		return productRepo.findById(id).get();
	}
	
	@Override
	public DbProduct create(DbProduct record) {
		return productRepo.save(record);
	}
}
