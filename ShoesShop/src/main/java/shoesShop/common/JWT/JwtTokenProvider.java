package shoesShop.common.JWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import shoesShop.common.User.CustomUserDetails;

@Component
@Slf4j
public class JwtTokenProvider {
	

	private static final String SECRET_KEY = "12345678912345678912345678912345678912345678912345678912345678912345678912345678912345678912345678912345678";
	 public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;
	 
	 public String generateToken(CustomUserDetails user) {
	        // Lấy thông tin người dùng và tạo chuỗi JSON cho thông tin đó
	        Map<String, Object> claims = new HashMap();
	        claims.put("email", user.getUsername());
	        claims.put("fullName", user.getFullName());
	        claims.put("phoneNumber", user.getPhoneNumber());
	        claims.put("roles", user.getAuthorities());
	        SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	        // Tạo JWT token bằng thư viện jwt
	        return Jwts.builder()
	                .setSubject(user.getUsername())
	                .setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
	                .signWith(secretKey)
	                .claim("user", claims)
	                .compact();
	    }
	 
	 
	// Lấy email từ jwt
	    public String getEmailFromJWT(String token) {
	    	SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	    	 Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
	    	 String email = claimsJws.getBody().get("user", Map.class).get("email").toString();
	        return email;
	    }
	    // lay HSD
	    public Date getExpirationDateFromToken(String token) {
	    	SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	    	 Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
	    	 Long expTime = claimsJws.getBody().get("exp", Long.class);
	    	 Date expDate = new Date(expTime * 1000);
	        return expDate;
	    }
	    //
	    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
	    	SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	        Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
	        Claims claims = claimsJws.getBody();
	        return claimsResolver.apply(claims);
	    }
	    //laay value cua token
	    public Claims getAllClaimsFromToken(String token) {
	    	SecretKey key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
	    }
	    //
	    public Boolean isTokenExpired(String token) {
	        final Date expiration = getExpirationDateFromToken(token);
	        return expiration.before(new Date());
	    }
	    //
	  //validate token
	    public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = getEmailFromJWT(token);
	        Date dateToken = getExpirationDateFromToken(token);
	        if(username == null && dateToken.before(dateToken)) {
	        	System.out.println("The current date is before the expiration date.");
	        }
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }

	
}
