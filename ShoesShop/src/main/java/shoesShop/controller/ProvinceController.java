package shoesShop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Province.Province;
import shoesShop.common.Province.ProvinceService;

@RestController
@RequestMapping("api/v1/provinces")
public class ProvinceController {
	@Autowired
	ProvinceService provinceService;
	
	@GetMapping
	public ResponseEntity<Collection<Province>> retrieveAll() throws Exception {
		Collection<Province> provinces = provinceService.retrieveAll();
		return new ResponseEntity<Collection<Province>>(provinces, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Province> retrieveOne(@PathVariable("id") Integer id) throws Exception {
		Province province = provinceService.retrieveOne(id);
		if (province != null) {
			return new ResponseEntity<Province>(province, HttpStatus.OK);
		}

		return new ResponseEntity<Province>(HttpStatus.NOT_FOUND);
	}
}
