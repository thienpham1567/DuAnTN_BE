package shoesShop.common.Color;

import shoesShop.common.IConverter;

public class ColorConverter implements IConverter<DbColor, Color>{

	@Override
	public DbColor convertModelToDb(Color input) {
		return null;
	}

	@Override
	public Color convertDbToModel(DbColor input) {
		return input == null ? null : new Color(input.colorId,input.value);
	}
	
}
