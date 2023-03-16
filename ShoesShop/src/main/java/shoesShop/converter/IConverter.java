package shoesShop.converter;

public interface IConverter<TDb, TModel> {
	TModel convertModelToDb(TDb input);
	TDb convertDbToModel(TModel input);
}
