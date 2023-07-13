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
	@PostMapping
	public ResponseEntity<ProductImage> create(@RequestBody ProductImage productImage, BindingResult result) throws Exception {
		if(productImage == null || result.hasErrors()) {
			return new ResponseEntity<ProductImage>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<ProductImage>(this.productImageService.create(productImage), HttpStatus.CREATED);
	}
	
	/*--Update productVariationSize--*/
	@PutMapping("{id}")
	public ResponseEntity<ProductImage> update(@RequestBody ProductImage productImage, @PathVariable("id") Integer id, BindingResult result) {

		if (productImage == null || result.hasErrors())
			return new ResponseEntity<ProductImage>(HttpStatus.BAD_REQUEST);
		
		ProductImage updatedProductImage = this.productImageService.update(productImage, id);

		return updatedProductImage != null
				? new ResponseEntity<ProductImage>(updatedProductImage, HttpStatus.OK)
				: new ResponseEntity<ProductImage>(HttpStatus.BAD_REQUEST);
	}
	
	/*--Delete productImages--*/
	@DeleteMapping("{id}")
	public ResponseEntity<ProductImage> delete(@PathVariable("id") Integer id) throws Exception{
		return this.productImageService.delete(id) ? new ResponseEntity<ProductImage>(HttpStatus.NO_CONTENT) : new ResponseEntity<ProductImage>(HttpStatus.BAD_REQUEST);
	}
}
