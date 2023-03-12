package shoesShop.service;

import java.util.Collection;

public abstract class RecordManager<T> implements IRecordManager<T>{
	public Collection<T> getAll() throws Exception {
		throw new Exception();
	}
	
	public T getOne(int id) throws Exception {
		throw new Exception();
	}
	
	public T create(T record) throws Exception {
		throw new Exception();
	}
	
	public T update(T record, int id) throws Exception {
		throw new Exception();
	}
	
	public boolean delete(int id) throws Exception {
		throw new Exception();
	}
}
