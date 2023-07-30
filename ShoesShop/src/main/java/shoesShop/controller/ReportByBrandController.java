package shoesShop.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.OrderLine.IReportByBrandService;


@CrossOrigin("*")
@RestController
public class ReportByBrandController {
	@Autowired
	IReportByBrandService reportByBrandsService;
	
	/*--Get productVariationSize in Admin page--*/
	@GetMapping("/api/v1/admin/report-by-brands")
	public ResponseEntity<?> getReportByBrands(){
		List<Object[]> result = reportByBrandsService.getReportByBrands();
		List<Map<String, Object>> response = new ArrayList<>();
		for(Object[] row : result) {
			Map<String, Object> item = new HashMap<>();
			item.put("quantity", row[0]);
			item.put("name", row[1]);
			response.add(item);			
		}
		return ResponseEntity.ok(response);
	}
}
