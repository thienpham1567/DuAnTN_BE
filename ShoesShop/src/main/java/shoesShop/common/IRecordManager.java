package shoesShop.common;

import java.util.Collection;

public interface IRecordManager<T> {
	//Collection<T> retrieveAll() throws Exception;
	
	/*--Filter: get all products by brand id--*/
	//Collection<T> retrieveAll(Integer id) throws Exception;
	
	/*--Filter: get all products by category id--*/
	//Collection<T> retrieveAllProductByBrandId(Integer id) throws Exception;

	T retrieveOne(Integer id) throws Exception;

	T create(T record) throws Exception;

	T update(T record, Integer id) throws Exception;

	Boolean delete(Integer id) throws Exception;
}
