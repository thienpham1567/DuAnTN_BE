package shoesShop.converter;

public interface ICombiner<T> {
	void combine(T original, T update);
}
