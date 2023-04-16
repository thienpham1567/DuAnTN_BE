package shoesShop.common.Category;

import java.util.Collection;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;

public class CategoryConverter implements ICombiner<DbCategory>, IConverter<DbCategory, Category> {
	@Override
	public void combine(DbCategory original, DbCategory update) {
		original.name = update.name;
	}

	@Override
	public DbCategory convertModelToDb(Category input) {
		return input == null ? null : new DbCategory(input.name);
	}

	@Override
	public Category convertDbToModel(DbCategory input) {
		return input == null ? null : new Category(input.name, input.categoryId, input.parentCategory == null ? new Category("") : new Category(input.parentCategory.name, input.parentCategory.categoryId));
	}
}
