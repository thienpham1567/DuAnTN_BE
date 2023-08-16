package shoesShop.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.ExpiredJwtException;
import shoesShop.common.Favorite.DbFavorite;
import shoesShop.common.Favorite.IFavoriteService;
import shoesShop.common.JWT.JwtTokenProvider;
import shoesShop.common.Product.Product;
import shoesShop.common.ProductVariations.ProductVariation;
import shoesShop.common.User.User;
import shoesShop.common.User.UserSerivce;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/favorites")
public class FavoriteController {
	@Autowired
	IFavoriteService favoriteService;
	
	@Autowired
	private JwtTokenProvider jwt;
	
	@Autowired
	UserSerivce userService;
	
	@GetMapping("{id}")
	public DbFavorite check(HttpServletRequest request, @PathVariable("id") Integer id) {
		String authorizationHeader = request.getHeader("Authorization");
		String email = null;
		String jwtToken = null;
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")){
				jwtToken = authorizationHeader.substring(7);
				try {
					email = jwt.getEmailFromJWT(jwtToken);
					User user = userService.findByEmail(email);
					DbFavorite favorite = favoriteService.findByUsernameAndProductId(user.userId, id);
					return favorite;
				} catch (IllegalArgumentException e) {
					System.out.println("Unable to get JWT Token");
				} catch (ExpiredJwtException e) {
					System.out.println("JWT Token has expired");
				}
		}
		return null;
	}
	
	
	
}
