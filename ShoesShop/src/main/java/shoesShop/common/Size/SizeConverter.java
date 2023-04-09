package shoesShop.common.Size;

import shoesShop.common.IConverter;

public class SizeConverter implements IConverter<DbSize, Size> {

	@Override
	public DbSize convertModelToDb(Size input) {
		return input == null ? null : new DbSize();
	}

	@Override
	public Size convertDbToModel(DbSize input) {
		return input == null ? null : new Size(input.sizeId, input.value, input.category.categoryId);
	}
}
