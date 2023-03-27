package shoesShop.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.converter.CategoryConverter;
import shoesShop.entity.DbCategory;
import shoesShop.model.Category;
import shoesShop.repository.ICategoryRepository;

@Service
public class CategoryService extends RecordManager<Category>{
	@Autowired
	ICategoryRepository categoryRepo;
	
	CategoryConverter converter = new CategoryConverter();
	
	@Override
	public Collection<Category> retrieveAll(){
		Collection<Category> categories = this.load(null).stream().map(dbCategory -> this.converter.convertDbToModel(dbCategory)).collect(Collectors.toList());
		return categories;
	}
	
	@Override
	public Category retrieveOne(Integer id){
		Category category = this.load(id).stream().map(dbCategory -> this.converter.convertDbToModel(dbCategory)).findFirst().get();
		return category;
	}
	
	@Override
	public Category create(Category category) {
		DbCategory dbCategory = this.converter.convertModelToDb(category);
		DbCategory createdCategory = this.categoryRepo.save(dbCategory);
		return this.converter.convertDbToModel(createdCategory);
	}
	
	@Override
	public Category update(Category category, Integer id) {
		DbCategory updateCategory = this.converter.convertModelToDb(category);
		
		DbCategory dbCategory = this.categoryRepo.findById(id).get();
		if(dbCategory != null) {
			this.converter.combine(dbCategory, updateCategory);
			DbCategory updateDbCategory = this.categoryRepo.save(dbCategory);
			return this.converter.convertDbToModel(updateDbCategory);
		}
		
		return null;
	}
	@Override
	public Boolean delete(Integer id) {
		if(this.categoryRepo.existsById(id)) {
			this.categoryRepo.deleteById(id);
			return true;
		}
		
		return false;
	}
	
	private Collection<DbCategory> load(Integer categoryId){
		Collection<DbCategory> dbCategories = this.categoryRepo.findAll();
		
		if(categoryId != null) {
			dbCategories = dbCategories.stream().filter(dbCategory -> dbCategory.categoryId == categoryId).collect(Collectors.toList());
		}
		
		
		
		return dbCategories;
	}
}
