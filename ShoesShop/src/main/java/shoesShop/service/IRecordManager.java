package shoesShop.service;

import java.util.Collection;

public interface IRecordManager<T> {
	Collection<T> getAll() throws Exception;
	T getOne(int id) throws Exception;
	T create(T record) throws Exception;
	T update(T record, int id) throws Exception;
	boolean delete(int id) throws Exception;
}
