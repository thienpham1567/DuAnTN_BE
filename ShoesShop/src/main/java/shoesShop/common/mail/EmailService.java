package shoesShop.common.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;

@Service
public class EmailService {
	
	 private final JavaMailSender emailSender;
	    
	 @Autowired
	 public EmailService(JavaMailSender emailSender) {
	    this.emailSender = emailSender;
	 }
	    
	 public void sendEmail(String to, String subject, String text) {
	    SimpleMailMessage message = new SimpleMailMessage();
	    message.setTo(to);
	    message.setSubject(subject);
	    message.setText(text);
	    emailSender.send(message);
	    }
}
