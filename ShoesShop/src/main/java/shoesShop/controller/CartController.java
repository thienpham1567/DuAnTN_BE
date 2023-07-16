package shoesShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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

@RestController
@RequestMapping("api/v1/cart")
public class CartController {
	@Autowired
	CartService cartService;
	
	@GetMapping
	public ResponseEntity<Cart> retrieveCart(@RequestParam(name = "cartId") String cartId) {
		Cart cart = this.cartService.retriveCart(cartId);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Cart> updateCart(@RequestBody CartItem cartItem) {
		Cart updatedCart = this.cartService.add(cartItem.cartId, cartItem);
		return new ResponseEntity<Cart>(updatedCart, HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{cartId}")
	public ResponseEntity<Cart> removeProductToCart(@PathVariable String cartId, @RequestParam(name = "cartItemId", required = true) Integer cartItemId) {
		Cart updatedCart = this.cartService.remove(cartId, cartItemId);
		return new ResponseEntity<Cart>(updatedCart, HttpStatus.OK);
	}
}
