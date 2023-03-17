package shoesShop.controller;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.entity.DbProduct;
import shoesShop.model.Product;
import shoesShop.service.ProductService;

@RestController
@RequestMapping("api/v1/products")
public class ProductController extends ApiController{
	@Autowired
	ProductService productService;

	@GetMapping
	public ResponseEntity<Collection<Product>> retrieveAll() {
		Collection<Product> products = productService.retrieveAll();

		return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Product> retrieveOne(@PathVariable("id") Integer id) {
		Product product = productService.retrieveOne(id);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}

		return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Product> create(@RequestBody @Valid Product product, BindingResult result) {
		if (product == null || result.hasErrors()) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Product>(this.productService.create(product), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@RequestBody @Valid Product product, Integer id, BindingResult result) {
		if (product == null || result.hasErrors()) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}

		return this.productService.update(product, id) != null
				? new ResponseEntity<Product>(this.productService.create(product), HttpStatus.OK)
				: new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> delete(Integer id) {
		return this.productService.delete(id) ? new ResponseEntity<Product>(HttpStatus.NO_CONTENT) : new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
	}
}
