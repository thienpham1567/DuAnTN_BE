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

import shoesShop.common.Brand.Brand;
import shoesShop.common.Brand.BrandService;

@RestController
@RequestMapping("api/v1/brands")
public class BrandController {
	@Autowired
	BrandService brandService;
	
	@GetMapping
	public ResponseEntity<Collection<Brand>> retrieveAll() throws Exception {
		Collection<Brand> brands = brandService.retrieveAll();
		return new ResponseEntity<Collection<Brand>>(brands, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Brand> retrieveOne(@PathVariable("id") Integer id) throws Exception {
		Brand brand = brandService.retrieveOne(id);
		if (brand != null) {
			return new ResponseEntity<Brand>(brand, HttpStatus.OK);
		}

		return new ResponseEntity<Brand>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Brand> create(@RequestBody @Valid Brand brand, BindingResult result) throws Exception {
		System.out.print(brand);
		if (brand == null || result.hasErrors()) {
			return new ResponseEntity<Brand>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Brand>(this.brandService.create(brand), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Brand> update(@RequestBody @Valid Brand brand,@PathVariable("id") Integer id, BindingResult result) throws Exception {
		if (brand == null || result.hasErrors()) {
			return new ResponseEntity<Brand>(HttpStatus.BAD_REQUEST);
		}
		
		Brand updatedBrand = this.brandService.update(brand, id);

		return updatedBrand != null
				? new ResponseEntity<Brand>(updatedBrand, HttpStatus.OK)
				: new ResponseEntity<Brand>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Brand> delete(@PathVariable("id") Integer id) throws Exception {
		return this.brandService.delete(id) ? new ResponseEntity<Brand>(HttpStatus.NO_CONTENT) : new ResponseEntity<Brand>(HttpStatus.BAD_REQUEST);
	}
}
