package shoesShop.controller;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.entity.DbProduct;
import shoesShop.payload.ProductDTO;
import shoesShop.service.ProductService;

@CrossOrigin("http://127.0.0.1:5173/")
@RestController
public class ProductController {
	@Autowired
	ProductService productService;
	
	@GetMapping("api/v1/products")
	public List<ProductDTO> getAllProducts(){
		return productService.getAll()
				.stream()
				.map(p -> new ProductDTO(p.getName(),p.getImageLink(),p.getPrice(),p.getInStock(),p.isAvailable(),p.getBrand().getBrandId(),p.getCategory().getCategoryId())).collect(Collectors.toList());
	}
}
