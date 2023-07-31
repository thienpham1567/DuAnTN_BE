package shoesShop.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Favorite.DbFavorite;
import shoesShop.common.Favorite.IFavoriteService;
import shoesShop.common.ProductVariations.ProductVariation;
import shoesShop.common.ProductVariations.ProductVariationService;
import shoesShop.common.Review.Review;
import shoesShop.common.Review.ReviewService;
import shoesShop.common.User.IUserRepository;
import shoesShop.common.User.User;
import shoesShop.common.User.UserSerivce;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
	@Autowired
	ProductVariationService productVariationService;
	
	@Autowired
	ReviewService reviewService;
	
	@Autowired
	IFavoriteService favoriteService;

	@GetMapping
	public ResponseEntity<Collection<ProductVariation>> retrieveAll(@RequestParam(name = "category", required = false) Integer categoryId, @RequestParam(name = "brand", required = false) Integer brandId, @RequestParam(name = "productId", required = false) Integer productId){
		Collection<ProductVariation> products = new ArrayList<>();
		if (categoryId != null || brandId != null) {
			products = this.productVariationService.retrieveAll(brandId, categoryId);
		} else if (productId != null) {
			products = this.productVariationService.retrieveProduct(productId);
		} else {			
			products = this.productVariationService.retrieveAll();
		}
		return new ResponseEntity<Collection<ProductVariation>>(products, HttpStatus.OK); 
	}
	
	@GetMapping("{id}")
	public ResponseEntity<ProductVariation> retrieveOne(@PathVariable("id") Integer id) {
		System.out.println("run...");
		// lấy ID để hiện prods detail
		ProductVariation product = productVariationService.retrieveOne(id);
		// Lấy status của user đang login
		System.out.println("run authen...99");
		User user = new User();
		user.setUserId(9);
		user.setEmailAddress("aaa2@gmail.com");
		
		DbFavorite favourite = favoriteService.create(user, product);
		
		Collection<Review> reviews = reviewService.getReviewByProductVariationId(id);
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
