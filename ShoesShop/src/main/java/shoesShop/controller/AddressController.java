package shoesShop.controller;

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
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Address.Address;
import shoesShop.common.Address.AddressService;

@RestController
@RequestMapping("api/v1/addresses")
public class AddressController {
	@Autowired
	AddressService addressService;
	
	@GetMapping
	public ResponseEntity<Collection<Address>> retrieveAll() throws Exception {
		Collection<Address> addresses = addressService.retrieveAll();
		return new ResponseEntity<Collection<Address>>(addresses, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Address> retrieveOne(@PathVariable("id") Integer id) throws Exception {
		Address address = addressService.retrieveOne(id);
		if (address != null) {
			return new ResponseEntity<Address>(address, HttpStatus.OK);
		}

		return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Address> create(@RequestBody @Valid Address address, BindingResult result) throws Exception {
		if (address == null || result.hasErrors()) {
			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Address>(this.addressService.create(address), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Address> update(@RequestBody @Valid Address address,@PathVariable("id") Integer id, BindingResult result) throws Exception {
		if (address == null || result.hasErrors()) {
			return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
		}
		
		Address updatedAddress = this.addressService.update(address, id);

		return updatedAddress != null
				? new ResponseEntity<Address>(updatedAddress, HttpStatus.OK)
				: new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Address> delete(@PathVariable("id") Integer id) throws Exception {
		return this.addressService.delete(id) ? new ResponseEntity<Address>(HttpStatus.NO_CONTENT) : new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
	}
}
