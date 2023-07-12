package shoesShop.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shoesShop.common.ProductImage.ProductImage;
import shoesShop.common.ProductImage.ProductImageService;

@RestController
@RequestMapping("api/v1/admin/productImages")
public class ProductImageAdminController {
	@Autowired
	ProductImageService productImageService;
	
	/*--Get productImages in Admin page--*/
	@GetMapping
	public ResponseEntity<Collection<ProductImage>> retrieveAll(){
		Collection<ProductImage> productImages = this.productImageService.retrieveAll();
		return new ResponseEntity<Collection<ProductImage>>(productImages, HttpStatus.OK); 
	}
	
	/*--Insert productVariationSize--*/
//	@PostMapping
//	public ResponseEntity<ProductVariationSize> create(@RequestBody ProductVariationSize productVariationSize, BindingResult result) throws Exception {
//		if(productVariationSize == null || result.hasErrors()) {
//			return new ResponseEntity<ProductVariationSize>(HttpStatus.BAD_REQUEST);
//		}
//		return new ResponseEntity<ProductVariationSize>(this.productVariationSizeService.create(productVariationSize), HttpStatus.CREATED);
//	}
	
	/*--Update productVariationSize--*/
//	@PutMapping("{id}")
//	public ResponseEntity<ProductVariationSize> update(@RequestBody ProductVariationSize productVariationSize, @PathVariable("id") Integer id, BindingResult result) {
//
//		if (productVariationSize == null || result.hasErrors())
//			return new ResponseEntity<ProductVariationSize>(HttpStatus.BAD_REQUEST);
//		
//		ProductVariationSize updatedProductVariationSize = this.productVariationSizeService.update(productVariationSize, id);
//
//		return updatedProductVariationSize != null
//				? new ResponseEntity<ProductVariationSize>(updatedProductVariationSize, HttpStatus.OK)
//				: new ResponseEntity<ProductVariationSize>(HttpStatus.BAD_REQUEST);
//	}
	
	/*--Delete productVariationSize--*/
//	@DeleteMapping("{id}")
//	public ResponseEntity<ProductVariationSize> delete(@PathVariable("id") Integer id) throws Exception{
//		return this.productVariationSizeService.delete(id) ? new ResponseEntity<ProductVariationSize>(HttpStatus.NO_CONTENT) : new ResponseEntity<ProductVariationSize>(HttpStatus.BAD_REQUEST);
//	}
}
