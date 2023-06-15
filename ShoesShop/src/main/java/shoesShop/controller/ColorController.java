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

import shoesShop.common.Color.Color;
import shoesShop.common.Color.ColorService;

@RestController
@RequestMapping("api/v1/colors")
public class ColorController {
	@Autowired
	ColorService colorService;
	
	@GetMapping
	public ResponseEntity<Collection<Color>> retrieveAll() {
		Collection<Color> colors = this.colorService.retrieveAll();
		
		return new ResponseEntity<Collection<Color>>(colors, HttpStatus.OK);
	}
	// test Postman oke 15/6
	@GetMapping("{id}")
	public ResponseEntity<Color> retrieveOne(@PathVariable("id") Integer id) throws Exception {
		Color color = colorService.retrieveOne(id);
		if (color != null) {
			return new ResponseEntity<Color>(color, HttpStatus.OK);
		}

		return new ResponseEntity<Color>(HttpStatus.NOT_FOUND);
	}
	// test Postman oke 15/6
	@PostMapping
	public ResponseEntity<Color> create(@RequestBody @Valid Color color, BindingResult result) throws Exception {
		System.out.print(color);
		if (color == null || result.hasErrors()) {
			return new ResponseEntity<Color>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Color>(this.colorService.create(color), HttpStatus.CREATED);
	}
	// test Postman oke 15/6
	@PutMapping("{id}")
	public ResponseEntity<Color> update(@RequestBody @Valid Color color,@PathVariable("id") Integer id, BindingResult result) throws Exception {
		if (color == null || result.hasErrors()) {
			return new ResponseEntity<Color>(HttpStatus.BAD_REQUEST);
		}
		
		Color updatedColor= this.colorService.update(color, id);

		return updatedColor != null
				? new ResponseEntity<Color>(updatedColor, HttpStatus.OK)
				: new ResponseEntity<Color>(HttpStatus.BAD_REQUEST);
	}
	// test Postman oke 15/6
	@DeleteMapping("{id}")
	public ResponseEntity<Color> delete(@PathVariable("id") Integer id) throws Exception {
		return this.colorService.delete(id) ? new ResponseEntity<Color>(HttpStatus.NO_CONTENT) : new ResponseEntity<Color>(HttpStatus.BAD_REQUEST);
	}
}
