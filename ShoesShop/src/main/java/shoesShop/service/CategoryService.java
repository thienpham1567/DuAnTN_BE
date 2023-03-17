package shoesShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.model.Product;
import shoesShop.repository.ICategoryRepository;

@Service
public class CategoryService extends RecordManager<Product>{
	@Autowired
	ICategoryRepository categoryRepo;
}
