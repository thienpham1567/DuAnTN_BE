package shoesShop.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.jsonwebtoken.Claims;
import shoesShop.common.JWT.JwtTokenProvider;
import shoesShop.common.User.ChangeUserPassword;
import shoesShop.common.User.CustomUserDetails;
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
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	UserConverter userConverter = new UserConverter();
	
	@GetMapping
	public ResponseEntity<Collection<User>> retrieveAll() throws Exception {
		Collection<User> users = new ArrayList<>();
		users = userService.retrieveAll();
		
		return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
	}
//	@GetMapping
//	public ResponseEntity<Collection<User>> getUserWithAdmin() throws Exception {
//		Collection<User> users = new ArrayList<>();
//		users = userService.retrieveUserAdmin(2);
//		
//		return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
//	}

	@GetMapping("email/{email}")
	public ResponseEntity<User> findBy(@PathVariable("email") String email){
		User user = userService.findByEmail(email);
		if (user != null) {
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("key/{key}")
	public ResponseEntity<Collection<User>> findByKey(@PathVariable("key") String key){
		Collection<User> users = userService.findKey(key);
		if (users != null ) {
			return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
		}
		return new ResponseEntity<Collection<User>>(users, HttpStatus.OK);
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
	
	@PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) throws Exception {
        String email = loginRequest.getEmail();
        String password = loginRequest.getPassword();
        
        // Kiểm tra xem email và mật khẩu có khớp với bản ghi người dùng trong cơ sở dữ liệu hay không
        CustomUserDetails user = (CustomUserDetails) userDetailService.loadUserByUsername(email);
        User userss = userService.findByEmail(email);
        boolean isMatch = passwordEncoder.matches(password,userss.password);
        if (!isMatch) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Sai tên đăng nhập hoặc mật khẩu!");
        }

        // Nếu thông tin đăng nhập hợp lệ, trả về token JWT
        String token = jwtTokenProvider.generateToken(user);
        
        
        String id = jwtTokenProvider.getEmailFromJWT(token);
        Date date = jwtTokenProvider.getExpirationDateFromToken(token);
        Claims claims = jwtTokenProvider.getAllClaimsFromToken(token);
        boolean ckeckTKExp = jwtTokenProvider.isTokenExpired(token);
        
        System.out.println(ckeckTKExp);
        System.out.println(claims);
        System.out.println(date.toString());
        System.out.println(id);
        return ResponseEntity.ok(token);
    }
	
		
    
    @PostMapping
	public ResponseEntity<User> create(@RequestBody @Valid User user, BindingResult result) throws Exception {
    	if (user == null || result.hasErrors()) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
    	User userCheck = userService.findByEmail(user.emailAddress);
    	if(userCheck != null) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
    	}

		return new ResponseEntity<User>(this.userService.create(user), HttpStatus.CREATED);
	}
    
    @PutMapping("{id}")
	public ResponseEntity<User> update(@RequestBody @Valid User user,@PathVariable("id") Integer id, BindingResult result) throws Exception {
		if (user == null || result.hasErrors()) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		
		User updatedUser = this.userService.update(user, id);

		return updatedUser != null
				? new ResponseEntity<User>(updatedUser, HttpStatus.OK)
				: new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<User> delete(@PathVariable("id") Integer id) throws Exception {
		return this.userService.delete(id) ? new ResponseEntity<User>(HttpStatus.NO_CONTENT) : new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/changepassword/{id}")
	public ResponseEntity<User> update(@PathVariable("id") Integer id, @RequestBody ChangeUserPassword  pass, BindingResult result) throws Exception {
		if (pass== null ||result.hasErrors()) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
		}
		User updateUser = this.userService.retrieveOne(id);
		boolean isMatch = passwordEncoder.matches(pass.getOldPassword(),updateUser.getPassword());
		
		if (!isMatch) {
			return new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
        }
		String encodPass =  passwordEncoder.encode(pass.getNewPassword());
		updateUser.setPassword(encodPass);
		User updatedUser = this.userService.update(updateUser, id);

		return updatedUser != null
				? new ResponseEntity<User>(updatedUser, HttpStatus.OK)
				: new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
	}
	
	
}
