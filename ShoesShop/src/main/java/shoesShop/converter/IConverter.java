package shoesShop.converter;

public interface IConverter<TEntity, TModel> {
	TEntity convertModelToDb(TModel input);
	TModel convertDbToModel(TEntity input);
}
