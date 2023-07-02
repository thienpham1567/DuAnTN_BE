package shoesShop.common.Category;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;

public class CategoryConverter implements ICombiner<DbCategory>, IConverter<DbCategory, Category> {
	@Override
	public void combine(DbCategory original, DbCategory update) {
		original.name = update.name;
//		original.code = update.code;
	}

	@Override
	public DbCategory convertModelToDb(Category input) {
		return input == null ? null : new DbCategory(input.name, input.code);
	}

	@Override
	public Category convertDbToModel(DbCategory input) {
		return input == null ? null : new Category(input.name, input.categoryId,input.code, input.parentCategory == null ? new Category("") : new Category(input.parentCategory.name, input.parentCategory.categoryId));
	}
	
	
//	@Override
//	public Category convertDbToModel(DbCategory input) {
//	    if (input == null) {
//	        return null;
//	    } else {
//	        Integer parentCategoryId = null;
//	        if (input.getParentCategory() != null) {
//	            parentCategoryId = input.getParentCategory().getCategoryId();
//	        }
//	        return new Category(input.getName(), input.getCategoryId(), parentCategoryId, input.parentCategory.);
//	    }
//	}
}
