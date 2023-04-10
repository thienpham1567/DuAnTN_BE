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

import shoesShop.common.ProductItem.ProductItem;
import shoesShop.common.ProductItem.ProductItemService;

@RestController
@RequestMapping("api/v1/products")
public class ProductController extends ApiController {
	@Autowired
	ProductItemService productItemService;

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
}
