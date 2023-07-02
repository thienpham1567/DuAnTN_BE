package shoesShop.common.Size;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.Category.CategoryConverter;

public class SizeConverter implements ICombiner<DbSize>, IConverter<DbSize, Size> {
	private CategoryConverter categoryConverter = new CategoryConverter();
	
	@Override
	public void combine(DbSize original, DbSize update) {
		original.value = update.value;
	}

	@Override
	public DbSize convertModelToDb(Size input) {
		return input == null ? null : new DbSize(input.value, input.category.categoryId);
	}

	@Override
	public Size convertDbToModel(DbSize input) {
		return input == null ? null : new Size(input.sizeId, input.value, input.code, categoryConverter.convertDbToModel(input.category));
	}
}
