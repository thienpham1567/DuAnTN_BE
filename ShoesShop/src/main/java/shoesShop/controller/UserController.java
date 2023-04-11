package shoesShop.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import shoesShop.common.Brand.Brand;
import shoesShop.common.ProductItem.ProductItem;
import shoesShop.common.User.IUserRepository;
import shoesShop.common.User.User;
import shoesShop.common.User.UserConverter;
import shoesShop.common.User.UserSerivce;
import shoesShop.myWebConfig.LoginRequest;
import shoesShop.myWebConfig.UserDetailsServiceImpl;


@RestController
@RequestMapping("api/v1/users")
public class UserController {
	@Autowired
	UserSerivce userService;
	@Autowired
	IUserRepository userRepo;
	@Autowired
	UserDetailsServiceImpl userDetailService;
	UserConverter userConverter = new UserConverter();
	@GetMapping
	public ResponseEntity<Collection<User>> retrieveAll() throws Exception {
		Collection<User> users = new ArrayList<>();
		users = userService.retrieveAll();
		
		return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
	}
	@GetMapping("email/{email}")
	public ResponseEntity<User> findBy(@PathVariable("email") String email){
		User user = userService.findByEmail(email);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("userid/{id}")
	public ResponseEntity<User> retrieveOne(@PathVariable("id") String id) throws Exception {
		Integer userId = Integer.parseInt(id);
		User user = userService.retrieveOne(userId);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) throws Exception {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        
		//final UserDetails user = userDetailService.loadUserByUsername(loginRequest.getEmail());
        // Kiểm tra xem email và mật khẩu có khớp với bản ghi người dùng trong cơ sở dữ liệu hay không
        UserDetails user = userDetailService.loadUserByUsername(email);
        User userss = userService.findByEmail(email);
//        if (!password.equals(user.getPassword())) {
//        	System.out.println(user);
//            System.out.println(user.getPassword());
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sai tên đăng nhập hoặc mật khẩu!");
//        }

        // Nếu thông tin đăng nhập hợp lệ, trả về token JWT
        String token = generateToken(user);
        return ResponseEntity.ok(token);
    }
	
    private String generateToken(UserDetails user) {
        // Lấy thông tin người dùng và tạo chuỗi JSON cho thông tin đó
        Map<String, Object> claims = new HashMap();
        claims.put("email", user.getUsername());
        //claims.put("fisrtname", user.get);
        claims.put("role", user.getAuthorities());

        // Tạo chuỗi JSON cho JWT payload
        String payload = new JSONObject(claims).toString();

        // Tạo JWT token bằng thư viện jjwt
        return Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .signWith(SignatureAlgorithm.HS256, "secret")
                .claim("user", payload)
                .compact();
    }
    
    
    
    @PostMapping
	public ResponseEntity<User> create(@RequestBody @Valid User user, BindingResult result) throws Exception {
		System.out.print(user);
		if (user == null || result.hasErrors()) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<User>(this.userService.create(user), HttpStatus.CREATED);
	}
}
