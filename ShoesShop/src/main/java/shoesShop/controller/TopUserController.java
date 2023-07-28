package shoesShop.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Order.IReportTopUserService;
@CrossOrigin("*")
@RestController
public class TopUserController {
	@Autowired
	IReportTopUserService reportTopUserService;
	
	@GetMapping("/api/v1/admin/top-users")
	public ResponseEntity<?> getTopUser(){
		List<Object[]> result = reportTopUserService.getTopUser();
		List<Map<String, Object>> response = new ArrayList<>();
		for (Object[] row : result) {
			Map<String, Object> item = new HashMap<>();
			item.put("quantity", row[0]);
			item.put("fullname", row[1]);
			response.add(item);	
		}
		return ResponseEntity.ok(response);
	}
}
