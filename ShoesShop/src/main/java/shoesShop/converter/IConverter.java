package shoesShop.converter;

public interface IConverter<TDb, TModel> {
	TModel convertDbToModel(TDb input);
	TDb convertModelToDb(TModel input);
}
