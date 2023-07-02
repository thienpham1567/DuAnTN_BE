package shoesShop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Product.Product;
import shoesShop.common.Product.ProductService;
import shoesShop.common.ProductVariations.ProductVariation;
import shoesShop.common.ProductVariations.ProductVariationService;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
	@Autowired
	ProductVariationService productVariationService;
	
	@Autowired
	ProductService productService;
	
	/*--Insert product--*/
	@PostMapping
	public ResponseEntity<Product> create(@RequestBody Product product, BindingResult result) throws Exception {
		if(product == null || result.hasErrors())
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Product>(this.productService.create(product), HttpStatus.CREATED);
	}

//	@GetMapping
//	public ResponseEntity<Collection<ProductItem>> retrieveAll(@RequestParam(name = "category", required = false) Integer categoryId,
//														   @RequestParam(name = "brand", required = false) Integer brandId) {
//		Collection<ProductItem> productItems = new ArrayList<>();
//		if (categoryId != null || brandId != null) {
//			productItems = productItemService.retrieveAll(brandId, categoryId);
//		} else {
//			productItems = productItemService.retrieveAll();
//		}
//		return new ResponseEntity<Collection<ProductItem>>(productItems, HttpStatus.OK);
//	}

	@GetMapping
	public ResponseEntity<Collection<ProductVariation>> retrieveAll(){
		Collection<ProductVariation> products = productVariationService.retrieveAll();
		return new ResponseEntity<Collection<ProductVariation>>(products, HttpStatus.OK); 
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProductVariation> retrieveOne(@PathVariable("id") Integer id) {
		ProductVariation product = productVariationService.retrieveOne(id);
		if (product != null) {
			return new ResponseEntity<ProductVariation>(product, HttpStatus.OK);
		}

		return new ResponseEntity<ProductVariation>(HttpStatus.NOT_FOUND);
	}
	
//	@GetMapping("/name/{name}")
//	public ResponseEntity<Collection<ProductItem>> productItemByName(@PathVariable("name") String name) {
//		System.out.print(name);
//		Collection<ProductItem> productItem = productItemService.getProductItemsByProductName(name);
//		if (productItem != null) {
//			return new ResponseEntity<Collection<ProductItem>>(productItem, HttpStatus.OK);
//		}
//
//		return new ResponseEntity<Collection<ProductItem>>(HttpStatus.NOT_FOUND);
//	}
}
