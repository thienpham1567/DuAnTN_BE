package shoesShop.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.entity.DbProduct;
import shoesShop.model.Product;
import shoesShop.service.ProductService;

@CrossOrigin("http://127.0.0.1:5173/")
@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@GetMapping("api/v1/products")
	public ResponseEntity<Collection<Product>> retrieveAll() {
		Collection<Product> products = productService.retrieveAll();
		return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("api/v1/products/{id}")
	public ResponseEntity<Product> retrieveOne(@PathVariable("id") Integer id) {
		Product product = productService.retrieveOne(id);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}
	
//	@PostMapping("api/v1/products")
//	public ResponseEntity<Product> create(@RequestBody Product product){
//		
//	}
}
