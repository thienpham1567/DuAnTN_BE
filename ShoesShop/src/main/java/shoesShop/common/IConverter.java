package shoesShop.common;

public interface IConverter<TEntity, TModel> {
	TEntity convertModelToDb(TModel input);
	TModel convertDbToModel(TEntity input);
}
