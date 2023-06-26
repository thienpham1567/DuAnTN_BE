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

import shoesShop.common.Review.Review;
import shoesShop.common.Review.ReviewService;

@RestController
@RequestMapping("api/v1/reviews")
public class ReviewController {
	@Autowired
	ReviewService reviewService;
	
	@GetMapping
	public ResponseEntity<Collection<Review>> retrieveAll(){
		Collection<Review> reviews = this.reviewService.retrieveAll();
		return new ResponseEntity<Collection<Review>>(reviews, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Review> create(@RequestBody Review review, BindingResult result) throws Exception {
		if(review == null || result.hasErrors())
			return new ResponseEntity<Review>(HttpStatus.BAD_REQUEST);
		return new ResponseEntity<Review>(this.reviewService.create(review), HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Review> delete(@PathVariable("id") Integer id) throws Exception{
		return this.reviewService.delete(id) ? new ResponseEntity<Review>(HttpStatus.NO_CONTENT) : new ResponseEntity<Review>(HttpStatus.BAD_REQUEST);
	}
}