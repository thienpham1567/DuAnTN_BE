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
	Collection<DbProduct> findAllProductsByBrandId(@Param("id") String id);
}
