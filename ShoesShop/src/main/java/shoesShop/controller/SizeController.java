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

import shoesShop.common.Size.Size;
import shoesShop.common.Size.SizeService;

@RestController
@RequestMapping("api/v1/sizes")
public class SizeController {	
	@Autowired
	SizeService sizeService;
	
	@GetMapping
	public ResponseEntity<Collection<Size>> retrieveAll() {
		Collection<Size> sizes = this.sizeService.retrieveAll();
		
		return new ResponseEntity<Collection<Size>>(sizes, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Size> retrieveOne(@PathVariable("id") Integer id) throws Exception {
		Size size = sizeService.retrieveOne(id);
		if (size != null) {
			return new ResponseEntity<Size>(size, HttpStatus.OK);
		}

		return new ResponseEntity<Size>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Size> create(@RequestBody @Valid Size size, BindingResult result) throws Exception {
		if (size == null || result.hasErrors()) {
			return new ResponseEntity<Size>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Size>(this.sizeService.create(size), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Size> update(@RequestBody @Valid Size size,@PathVariable("id") Integer id, BindingResult result) throws Exception {
		if (size == null || result.hasErrors()) {
			return new ResponseEntity<Size>(HttpStatus.BAD_REQUEST);
		}
		
		Size updatedSize = this.sizeService.update(size, id);

		return updatedSize != null
				? new ResponseEntity<Size>(updatedSize, HttpStatus.OK)
				: new ResponseEntity<Size>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Size> delete(@PathVariable("id") Integer id) throws Exception {
		return this.sizeService.delete(id) ? new ResponseEntity<Size>(HttpStatus.NO_CONTENT) : new ResponseEntity<Size>(HttpStatus.BAD_REQUEST);
	}

}
