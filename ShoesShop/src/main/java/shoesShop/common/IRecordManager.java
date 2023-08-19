package shoesShop.common;

import java.util.Collection;

import shoesShop.common.Order.Order;

public interface IRecordManager<T> {
	Collection<T> retrieveAll() throws Exception;

	T retrieveOne(Integer id) throws Exception;

	T create(T record) throws Exception;

	T update(T record, Integer id) throws Exception;

	Boolean delete(Integer id) throws Exception;

	T retrieveOne(String id) throws Exception;
}
