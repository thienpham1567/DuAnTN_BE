package shoesShop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.repository.IBrandRepository;

@Service
public class BrandService {
	@Autowired
	private IBrandRepository brandRepo;
}
