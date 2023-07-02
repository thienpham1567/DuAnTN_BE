package shoesShop.common.Size;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;


public class SizeConverter implements ICombiner<DbSize>, IConverter<DbSize, Size> {
	@Override
	public void combine(DbSize original, DbSize update) {
		original.value = update.value;
	}

	@Override
	public DbSize convertModelToDb(Size input) {
		return input == null ? null : new DbSize(input.value, input.categoryId);
		
	}

	@Override
	public Size convertDbToModel(DbSize input) {
		return input == null ? null : new Size(input.sizeId, input.value, input.category.categoryId);
	}

}
