package shoesShop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shoesShop.common.Ward.Ward;
import shoesShop.common.Ward.WardService;

@RestController
@RequestMapping("api/v1/wards")
public class WardController {
	@Autowired
	WardService wardService;
	
	@GetMapping
	public ResponseEntity<Collection<Ward>> retrieveAll() throws Exception {
		Collection<Ward> wards = this.wardService.retrieveAll();
		return new ResponseEntity<Collection<Ward>>(wards, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Ward> retrieveOne(@PathVariable("id") Integer id) throws Exception {
		Ward ward = this.wardService.retrieveOne(id);
		if (ward != null) {
			return new ResponseEntity<Ward>(ward, HttpStatus.OK);
		}

		return new ResponseEntity<Ward>(HttpStatus.NOT_FOUND);
	}
}
