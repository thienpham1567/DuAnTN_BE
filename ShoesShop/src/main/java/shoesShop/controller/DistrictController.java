package shoesShop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.District.District;
import shoesShop.common.District.DistrictService;
import shoesShop.common.Province.Province;
import shoesShop.common.Province.ProvinceService;

@RestController
@RequestMapping("api/v1/districts")
public class DistrictController {
	@Autowired
	DistrictService districtService;
	
	@GetMapping
	public ResponseEntity<Collection<District>> retrieveAll() throws Exception {
		Collection<District> districts = this.districtService.retrieveAll();
		return new ResponseEntity<Collection<District>>(districts, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<District> retrieveOne(@PathVariable("id") Integer id) throws Exception {
		District district = this.districtService.retrieveOne(id);
		if (district != null) {
			return new ResponseEntity<District>(district, HttpStatus.OK);
		}

		return new ResponseEntity<District>(HttpStatus.NOT_FOUND);
	}
}
