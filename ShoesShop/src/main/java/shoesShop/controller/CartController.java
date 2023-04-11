package shoesShop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Cart.Cart;
import shoesShop.common.Cart.CartService;
import shoesShop.common.CartItem.CartItem;
import shoesShop.common.CartItem.CartItemService;
import shoesShop.common.ProductItem.ProductItem;
import shoesShop.common.ProductItem.ProductItemService;

@RestController
@RequestMapping("api/v1/cart")
public class CartController extends ApiController{
	@Autowired
	CartService cartService;
	
	@Autowired
	CartItemService cartItemService;
	
	@Autowired
	ProductItemService productItemService;
	
	@GetMapping
	public ResponseEntity<Collection<CartItem>> retrieveCart() {
		Collection<CartItem> cartItems = this.cartItemService.retrieveAll();
		return new ResponseEntity<Collection<CartItem>>(cartItems, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Cart> updateCart(@RequestBody CartItem cartItem) {
		ProductItem product = this.productItemService.retrieveOne(cartItem.productItemId);
		Cart updatedCart = this.cartService.add(cartItem.cartId, cartItem.quantity, product);
		return new ResponseEntity<Cart>(updatedCart, HttpStatus.OK);
	}
	
	@GetMapping("/remove/{cartId}")
	public ResponseEntity<Cart> removeProductToCart(@PathVariable String cartId, @RequestParam(name = "cartItem", required = false) Integer cartItem) {
		Cart updatedCart = this.cartService.remove(cartId, cartItem);
		return new ResponseEntity<Cart>(updatedCart, HttpStatus.OK);
	}
}
