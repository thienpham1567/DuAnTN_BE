package shoesShop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
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
}
