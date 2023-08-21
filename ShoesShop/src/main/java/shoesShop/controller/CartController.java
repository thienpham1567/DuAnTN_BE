package shoesShop.controller;

import javax.servlet.http.HttpServletRequest;

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

import io.jsonwebtoken.ExpiredJwtException;
import shoesShop.common.Cart.Cart;
import shoesShop.common.Cart.CartService;
import shoesShop.common.Cart.DbCart;
import shoesShop.common.CartItem.CartItem;
import shoesShop.common.JWT.JwtTokenProvider;
import shoesShop.common.User.IUserRepository;
import shoesShop.common.User.User;
import shoesShop.common.User.UserConverter;
import shoesShop.common.User.UserSerivce;

@RestController
@RequestMapping("api/v1/cart")
public class CartController {
	@Autowired
	CartService cartService;
	
	@Autowired
	UserSerivce userService;
	
	@Autowired
	private JwtTokenProvider jwt;
	
	@Autowired
	private IUserRepository userRepository;
	
	private UserConverter userConverter;
	
	@GetMapping
	public ResponseEntity<Cart> retrieveCart(@RequestParam(name = "cartId") String cartId) {
		Cart cart = this.cartService.retriveCart(cartId);
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@PostMapping("/update")
	public ResponseEntity<Cart> updateCart(@RequestBody CartItem cartItem, HttpServletRequest request) {
		
		Cart updatedCart = this.cartService.add(cartItem.cartId, cartItem);
		String authorizationHeader = request.getHeader("Authorization");
		String email = null; 
		String jwtToken = null;
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			jwtToken = authorizationHeader.substring(7);
			try {
				email = jwt.getEmailFromJWT(jwtToken);
				User user = userService.findByEmail(email);
				updatedCart.setUser(user);
			} catch (IllegalArgumentException e) {
				System.out.println("Unable to get JWT Token");
			} catch (ExpiredJwtException e) {
				System.out.println("JWT Token has expired");
			}
		}
		System.out.println("User id: " + updatedCart);
		return new ResponseEntity<Cart>(updatedCart, HttpStatus.OK);
	}
	
	@DeleteMapping("/remove/{cartId}")
	public ResponseEntity<Cart> removeProductToCart(@PathVariable String cartId, @RequestParam(name = "cartItemId", required = true) Integer cartItemId) {
		Cart updatedCart = this.cartService.remove(cartId, cartItemId);
		return new ResponseEntity<Cart>(updatedCart, HttpStatus.OK);
	}
	
	@DeleteMapping("/detele/{cartId}")
	public ResponseEntity<Boolean> deteleCart(@PathVariable("cartd") String cartId) {
		Boolean isDeleted = this.cartService.removeCart(cartId);
		return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
	}
	
	@DeleteMapping("/detele/item/delete/{cartId}")
	public ResponseEntity<Boolean> deteleCartItem(@PathVariable String cartId) {
		Boolean isDeleted = this.cartService.removeCartItem(cartId);
		return new ResponseEntity<Boolean>(isDeleted, HttpStatus.OK);
	}
}
