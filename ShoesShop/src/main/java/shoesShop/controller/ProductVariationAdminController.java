package shoesShop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Product.Product;
import shoesShop.common.ProductVariations.ProductVariation;
import shoesShop.common.ProductVariations.ProductVariationService;

@RestController
@RequestMapping("api/v1/admin/productVariations")
public class ProductVariationAdminController {
	@Autowired
	ProductVariationService productVariationService;
	
	/*--Get productVariation in Admin page--*/
	@GetMapping
	public ResponseEntity<Collection<ProductVariation>> retrieveAll(){
		Collection<ProductVariation> productVariations = this.productVariationService.retrieveAll();
		return new ResponseEntity<Collection<ProductVariation>>(productVariations, HttpStatus.OK); 
	}
	
	/*--Insert productVariation--*/
	@PostMapping
	public ResponseEntity<ProductVariation> create(@RequestBody ProductVariation productVariation, BindingResult result) throws Exception {
		if(productVariation == null || result.hasErrors())
			return new ResponseEntity<ProductVariation>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<ProductVariation>(this.productVariationService.create(productVariation), HttpStatus.CREATED);
	}
	
	/*--Delete productVariation--*/
	@DeleteMapping("{id}")
	public ResponseEntity<ProductVariation> delete(@PathVariable("id") Integer id) throws Exception{
		return this.productVariationService.delete(id) ? new ResponseEntity<ProductVariation>(HttpStatus.NO_CONTENT) : new ResponseEntity<ProductVariation>(HttpStatus.BAD_REQUEST);
	}
}
