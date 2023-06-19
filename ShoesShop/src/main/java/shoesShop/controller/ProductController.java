package shoesShop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Product.Product;
import shoesShop.common.Product.ProductService;
import shoesShop.common.ProductDetails.ProductDTO;
import shoesShop.common.ProductItem.ProductItemService;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
	@Autowired
	ProductItemService productItemService;
	
	@Autowired
	ProductService productService;

	/*--Get all products--*/
	@GetMapping
	public ResponseEntity<Collection<Product>> retrieveAll(){
		Collection<Product> products = productService.retrieveAll();
		return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK); 
	}
	
	/*--Filter: get all products by brand id--*/
	@GetMapping("/products-by-brand/{id}")
	public ResponseEntity<Collection<Product>> retrieveAllProductsByBrandId(@PathVariable("id") Integer id){
		System.out.println("Load products by brand id");
		Collection<Product> products = productService.retrieveAllProductsByBrandId(id);
		if(products != null)
			return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
		return new ResponseEntity<Collection<Product>>(HttpStatus.NOT_FOUND);
	}
	
	/*--Filter: get all products by category id--*/
	@GetMapping("/products-by-category/{id}")
	public ResponseEntity<Collection<Product>> retrieveAllProductsByCategoryId(@PathVariable("id") Integer id) {
		System.out.println("Load products by category id");
		Collection<Product> products = productService.retrieveAllProductsByCategoryId(id);
		if(products != null)
			return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
		return new ResponseEntity<Collection<Product>>(HttpStatus.NOT_FOUND);
	}
	
	/*--
	 * Get product details
	 * 		1 sản phẩm
	 * 			3 màu => 1 màu 5 tấm hình - nhiều size
	 * 
	 * --*/
	@GetMapping("{id}")
	public ResponseEntity<Collection<ProductDTO>> retrieveOne(@PathVariable("id") Integer id) {
		Collection<ProductDTO> productDetail = productService.getProductDetails(id);
		if (productDetail != null && !productDetail.isEmpty()) {
			return new ResponseEntity<Collection<ProductDTO>>(productDetail, HttpStatus.OK);
		}
		return new ResponseEntity<Collection<ProductDTO>>(HttpStatus.NOT_FOUND);
	}
	
	/*--Search product by product name--*/
	@GetMapping("/products-by-name/{name}")
	public ResponseEntity<Collection<Product>> searchProductsByName(@PathVariable("name") String name) {
		System.out.print(name);
		Collection<Product> products = productService.searchProductsByName(name);
		if (products != null) {
			return new ResponseEntity<Collection<Product>>(products, HttpStatus.OK);
		}

		return new ResponseEntity<Collection<Product>>(HttpStatus.NOT_FOUND);
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
}
