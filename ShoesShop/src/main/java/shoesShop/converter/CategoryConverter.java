package shoesShop.converter;

import shoesShop.entity.DbCategory;
import shoesShop.model.Category;

public class CategoryConverter implements ICombiner<DbCategory>,IConverter<Category, DbCategory>{

	@Override
	public void combine(DbCategory original, DbCategory update) {
		original.code = update.code;
		original.description = update.description;
	}
	@Override
	public DbCategory convertModelToDb(Category input) {
		return input == null ? null : new DbCategory(input.code,input.description);
	}

	@Override
	public Category convertDbToModel(DbCategory input) {
		return input == null ? null : new Category(
				input.description,
				input.code,
				input.categoryId
				);
	}

	
	
}
