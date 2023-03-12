package shoesShop.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.entity.Product;
import shoesShop.repository.IProductRepository;

@Service
public class ProductService {
	@Autowired
	IProductRepository productRepo;
	
	public List<Product> getAll(){
		return productRepo.findAll();
	}
}
