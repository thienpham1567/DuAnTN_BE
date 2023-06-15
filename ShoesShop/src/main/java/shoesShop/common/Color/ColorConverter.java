package shoesShop.common.Color;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;

public class ColorConverter implements ICombiner<DbColor>, IConverter<DbColor, Color>{
	@Override
	public void combine(DbColor original, DbColor update) {
		original.value = update.value;
	}
	
	@Override
	public DbColor convertModelToDb(Color input) {
		return input == null ? null : new DbColor(input.value);
	}

	@Override
	public Color convertDbToModel(DbColor input) {
		return input == null ? null : new Color(input.colorId,input.value);
	}
	
}
