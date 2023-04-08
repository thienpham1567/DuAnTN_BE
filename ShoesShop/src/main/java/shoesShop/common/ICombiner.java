package shoesShop.common;

public interface ICombiner<T> {
	void combine(T original, T update);
}
