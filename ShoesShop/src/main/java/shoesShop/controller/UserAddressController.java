package shoesShop.controller;

import java.util.ArrayList;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.UserAddress.UserAddress;
import shoesShop.common.UserAddress.UserAddressService;

@RestController
@RequestMapping("api/v1/userAddresses")
public class UserAddressController {
	@Autowired
	UserAddressService userAddressService;
	
	@GetMapping
	public ResponseEntity<Collection<UserAddress>> retrieveAll(@RequestParam(name = "userId", required = false) Integer userId, @RequestParam(name = "isDefault", required = false) Boolean isDefault) throws Exception {
		Collection<UserAddress> userAddresses = new ArrayList<>();
		
		if (userId != null && isDefault != null) {
			userAddresses = this.userAddressService.retrieveDefaultAddressByUser(userId, isDefault);
		} else if (userId != null) {
			userAddresses = userAddressService.retrieveByUser(userId);
		} else {
			userAddresses = userAddressService.retrieveAll();
		}
		return new ResponseEntity<Collection<UserAddress>>(userAddresses, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<UserAddress> retrieveOne(@PathVariable("id") Integer id) throws Exception {
		UserAddress userAddress = userAddressService.retrieveOne(id);
		if (userAddress != null) {
			return new ResponseEntity<UserAddress>(userAddress, HttpStatus.OK);
		}

		return new ResponseEntity<UserAddress>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<UserAddress> create(@RequestBody @Valid UserAddress userAddress, BindingResult result) throws Exception {
		if (userAddress == null || result.hasErrors()) {
			return new ResponseEntity<UserAddress>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<UserAddress>(this.userAddressService.create(userAddress), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<UserAddress> update(@RequestBody @Valid UserAddress userAddress,@PathVariable("id") Integer id, BindingResult result) throws Exception {
		if (userAddress == null || result.hasErrors()) {
			return new ResponseEntity<UserAddress>(HttpStatus.BAD_REQUEST);
		}
		
		UserAddress updatedUserAddress = this.userAddressService.update(userAddress, id);

		return updatedUserAddress != null
				? new ResponseEntity<UserAddress>(updatedUserAddress, HttpStatus.OK)
				: new ResponseEntity<UserAddress>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<UserAddress> delete(@PathVariable("id") Integer id) throws Exception {
		return this.userAddressService.delete(id) ? new ResponseEntity<UserAddress>(HttpStatus.NO_CONTENT) : new ResponseEntity<UserAddress>(HttpStatus.BAD_REQUEST);
	}
}
