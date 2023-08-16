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
import shoesShop.common.Product.IProductInventoryService;


@CrossOrigin("*")
@RestController
public class ProductInventoryController {
	@Autowired
	IProductInventoryService productInventoryService;
	
	/*--Get report by brand in Admin page--*/
	@GetMapping("/api/v1/admin/product-inventory")
	public ResponseEntity<?> getProductInventory(){
		List<Object[]> result = productInventoryService.getProductInventory();
		List<Map<String, Object>> response = new ArrayList<>();
		for(Object[] row : result) {
			Map<String, Object> item = new HashMap<>();
			item.put("name", row[0]);
			item.put("quantity", row[1]);
			item.put("color", row[2]);
			item.put("size", row[3]);
			response.add(item);			
		}
		return ResponseEntity.ok(response);
	}
}
