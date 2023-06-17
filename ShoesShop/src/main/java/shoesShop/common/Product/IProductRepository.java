package shoesShop.common.Product;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<DbProduct, Integer> {
	@Query(value = "select * from Products s where s.Name like %:keyword%", nativeQuery = true)
	Collection<DbProduct> findByKeyword(@Param("keyword") String keyword);
	
	/*--Filter: get all products by brand id--*/
	@Query(value = "select * from products p inner join brands b on p.brand_id = b.brand_id where b.brand_id = ?1;", nativeQuery = true)
	Collection<DbProduct> findAllProductsByBrandId(@Param("id") Integer id);
	
	/*--Filter: get all products by category id--*/
	@Query(value = "select * from products p inner join categories c on p.category_id = c.category_id where c.category_id = ?1;", nativeQuery = true)
	Collection<DbProduct> findAllProductsByCategoryId(@Param("id") Integer id);
	
	/*--Search product by product name--*/
	@Query(value = "SELECT distinct p from DbProduct p WHERE p.name like %?1%")
	Collection<DbProduct> searchProductsByName(String name);
}
