package shoesShop.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.entity.Product;
import shoesShop.repository.IProductRepository;

@Service
public class ProductService extends RecordManager<Product>{
	@Autowired
	private IProductRepository productRepo;
	
	@Override
	public List<Product> getAll(){
		return productRepo.findAll();
	}
	
	@Override
	public Product getOne(int id){
		return productRepo.findById(id).get();
	}
	
	@Override
	public Product create(Product record) {
		return productRepo.save(record);
	}
}
