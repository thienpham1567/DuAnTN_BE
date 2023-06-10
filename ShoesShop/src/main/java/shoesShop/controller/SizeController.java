//package shoesShop.controller;
//
//import java.util.Collection;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import shoesShop.common.Size.Size;
//import shoesShop.common.Size.SizeService;
//
//@RestController
//@RequestMapping("api/v1/sizes")
//public class SizeController {	
//	@Autowired
//	SizeService sizeService;
//	
//	@GetMapping
//	public ResponseEntity<Collection<Size>> retrieveAll() {
//		Collection<Size> sizes = this.sizeService.retrieveAll();
//		
//		return new ResponseEntity<Collection<Size>>(sizes, HttpStatus.OK);
//	}
//}
