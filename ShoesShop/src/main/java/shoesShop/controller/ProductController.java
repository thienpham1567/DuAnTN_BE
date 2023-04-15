package shoesShop.controller;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Product.Product;
import shoesShop.common.Product.ProductService;
import shoesShop.common.ProductItem.ProductItem;
import shoesShop.common.ProductItem.ProductItemService;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
	@Autowired
	ProductItemService productItemService;
	
	@Autowired
	ProductService productService;

	@GetMapping
	public ResponseEntity<Collection<ProductItem>> retrieveAll(@RequestParam(name = "category", required = false) Integer categoryId,
														   @RequestParam(name = "brand", required = false) Integer brandId) {
		Collection<ProductItem> productItems = new ArrayList<>();
		if (categoryId != null || brandId != null) {
			productItems = productItemService.retrieveAll(brandId, categoryId);
		} else {
			productItems = productItemService.retrieveAll();
		}
		return new ResponseEntity<Collection<ProductItem>>(productItems, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<ProductItem> retrieveOne(@PathVariable("id") Integer id) {
		System.out.print(id);
		ProductItem productItem = productItemService.retrieveOne(id);
		if (productItem != null) {
			return new ResponseEntity<ProductItem>(productItem, HttpStatus.OK);
		}

		return new ResponseEntity<ProductItem>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Collection<ProductItem>> productItemByName(@PathVariable("name") String name) {
		System.out.print(name);
		Collection<ProductItem> productItem = productItemService.getProductItemsByProductName(name);
		if (productItem != null) {
			return new ResponseEntity<Collection<ProductItem>>(productItem, HttpStatus.OK);
		}

		return new ResponseEntity<Collection<ProductItem>>(HttpStatus.NOT_FOUND);
	}
	
//	@GetMapping("/nameproduct/{name}")
//	public ResponseEntity<Collection<Product>> productByName(@PathVariable("name") String name) {
//		System.out.print(name);
//		Collection<Product> product = productService.findByKeyword(name);
//		if (product != null) {
//			return new ResponseEntity<Collection<Product>>(product, HttpStatus.OK);
//		}
//
//		return new ResponseEntity<Collection<Product>>(HttpStatus.NOT_FOUND);
//	}
}
