package shoesShop.controller;

import java.time.format.DateTimeFormatter;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Product.Product;
import shoesShop.common.Product.ProductService;
@RestController
@RequestMapping("api/v1/admin/products")
public class ProductAdminController {
	@Autowired
	ProductService productService;
	
	/*--Get product in Admin page--*/
	@GetMapping
	public ResponseEntity<Collection<Product>> findAll(){
		Collection<Product> products = this.productService.retrieveAll();
		return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK); 
	}
	
	/*--Insert product--*/
	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product, BindingResult result) throws Exception {
		if(product == null || result.hasErrors())
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Product>(this.productService.create(product), HttpStatus.CREATED);
	}
}
