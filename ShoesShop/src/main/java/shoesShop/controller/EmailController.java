package shoesShop.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.User.User;
import shoesShop.common.User.UserSerivce;
import shoesShop.common.mail.EmailService;

@RestController
@RequestMapping("api/v1/email")
public class EmailController {
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private UserSerivce userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostMapping("/send-email/{email}")
    public void sendEmail(@PathVariable("email") String email) throws Exception {
		String newPassword = UUID.randomUUID().toString();
	
		User user = this.userService.findByEmail(email);
		String encodPass =  passwordEncoder.encode(newPassword);
		user.setPassword(encodPass);
		this.userService.update(user, user.userId);
		
        String to = email;
        String subject ="Mat khau moi";
        String text ="Mật Khẩu mới của bạn là: " + newPassword;
        
        emailService.sendEmail(to, subject, text);
    }
}
