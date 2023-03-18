package shoesShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.model.Brand;
import shoesShop.model.Product;
import shoesShop.repository.IBrandRepository;

@Service
public class BrandService extends RecordManager<Brand>{
	@Autowired
	private IBrandRepository brandRepo;
}
