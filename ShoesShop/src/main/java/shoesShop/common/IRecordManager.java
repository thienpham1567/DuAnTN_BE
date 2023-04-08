package shoesShop.common;

import java.util.Collection;

public interface IRecordManager<T> {
	Collection<T> retrieveAll() throws Exception;

	T retrieveOne(Integer id) throws Exception;

	T create(T record) throws Exception;

	T update(T record, Integer id) throws Exception;

	Boolean delete(Integer id) throws Exception;
}
