package shoesShop.common;

import java.util.Collection;

public abstract class RecordManager<T> implements IRecordManager<T> {
	
	public Collection<T> retrieveAll() throws Exception {
		throw new Exception();
	}
	
	/*--Filter: get all products by category id--*/
	public Collection<T> retrieveAllProductsByCategoryId(Integer id) throws Exception {
		throw new Exception();
	}
	
	/*--Filter: get all products by brand id--*/
	public Collection<T> retrieveAllProductsByBrandId(Integer id) throws Exception {
		throw new Exception();
	}

	public T retrieveOne(Integer id) throws Exception {
		throw new Exception();
	}

	public T retrieveOne(String id) throws Exception {
		throw new Exception();
	}
	public T create(T record) throws Exception {
		throw new Exception();
	}

	public T update(T record, Integer id) throws Exception {
		throw new Exception();
	}

	public Boolean delete(Integer id) throws Exception {
		throw new Exception();
	}
}
