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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.Product.Product;
import shoesShop.common.ProductVariationSizes.ProductVariationSize;
import shoesShop.common.ProductVariationSizes.ProductVariationSizeService;
import shoesShop.common.ProductVariations.ProductVariation;
import shoesShop.common.ProductVariations.ProductVariationService;

@RestController
@RequestMapping("api/v1/admin/productVariationSizes")
public class ProductVariationSizeAdminController {
	@Autowired
	ProductVariationSizeService productVariationSizeService;
	
	/*--Get productVariationSize in Admin page--*/
	@GetMapping
	public ResponseEntity<Collection<ProductVariationSize>> retrieveAll(){
		Collection<ProductVariationSize> productVariationSizes = this.productVariationSizeService.retrieveAll();
		return new ResponseEntity<Collection<ProductVariationSize>>(productVariationSizes, HttpStatus.OK); 
	}
	
	/*--Insert productVariationSize--*/
	@PostMapping
	public ResponseEntity<ProductVariationSize> create(@RequestBody ProductVariationSize productVariationSize, BindingResult result) throws Exception {
		if(productVariationSize == null || result.hasErrors()) {
			return new ResponseEntity<ProductVariationSize>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ProductVariationSize>(this.productVariationSizeService.create(productVariationSize), HttpStatus.CREATED);
	}
	
	/*--Update productVariationSize--*/
	@PutMapping("{id}")
	public ResponseEntity<ProductVariationSize> update(@RequestBody ProductVariationSize productVariationSize, @PathVariable("id") Integer id, BindingResult result) {

		if (productVariationSize == null || result.hasErrors())
			return new ResponseEntity<ProductVariationSize>(HttpStatus.BAD_REQUEST);
		
		ProductVariationSize updatedProductVariationSize = this.productVariationSizeService.update(productVariationSize, id);

		return updatedProductVariationSize != null
				? new ResponseEntity<ProductVariationSize>(updatedProductVariationSize, HttpStatus.OK)
				: new ResponseEntity<ProductVariationSize>(HttpStatus.BAD_REQUEST);
	}
	
	/*--Delete productVariationSize--*/
	@DeleteMapping("{id}")
	public ResponseEntity<ProductVariationSize> delete(@PathVariable("id") Integer id) throws Exception{
		return this.productVariationSizeService.delete(id) ? new ResponseEntity<ProductVariationSize>(HttpStatus.NO_CONTENT) : new ResponseEntity<ProductVariationSize>(HttpStatus.BAD_REQUEST);
	}
}
