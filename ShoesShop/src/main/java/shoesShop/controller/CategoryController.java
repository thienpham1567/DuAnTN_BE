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

import shoesShop.model.Category;
import shoesShop.service.CategoryService;

@RestController
@RequestMapping("api/v1/categories/")
public class CategoryController extends ApiController{
	@Autowired
	CategoryService categoryService;
	
	@GetMapping
	public ResponseEntity<Collection<Category>> retrieveAll() {
		Collection<Category> categories = categoryService.retrieveAll();

		return new ResponseEntity<Collection<Category>>(categories, HttpStatus.OK);
	}

	@GetMapping("{id}")
	public ResponseEntity<Category> retrieveOne(@PathVariable("id") Integer id) {
		Category category = categoryService.retrieveOne(id);
		if (category != null) {
			return new ResponseEntity<Category>(category, HttpStatus.OK);
		}

		return new ResponseEntity<Category>(HttpStatus.NOT_FOUND);
	}

	@PostMapping
	public ResponseEntity<Category> create(@RequestBody @Valid Category category, BindingResult result) {
		System.out.print(category);
		if (category == null || result.hasErrors()) {
			return new ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<Category>(this.categoryService.create(category), HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public ResponseEntity<Category> update(@RequestBody @Valid Category category,@PathVariable("id") Integer id, BindingResult result) {
		if (category == null || result.hasErrors()) {
			return new ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
		}
		
		Category updatedCategory = this.categoryService.update(category, id);

		return updatedCategory != null
				? new ResponseEntity<Category>(updatedCategory, HttpStatus.OK)
				: new ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Category> delete(@PathVariable("id") Integer id) {
		return this.categoryService.delete(id) ? new ResponseEntity<Category>(HttpStatus.NO_CONTENT) : new ResponseEntity<Category>(HttpStatus.BAD_REQUEST);
	}
}
