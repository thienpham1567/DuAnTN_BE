package shoesShop.common.Product;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductRepository extends JpaRepository<DbProduct, Integer> {
	@Query(value = "select * from Products s where s.Name like %:keyword%", nativeQuery = true)
	Collection<DbProduct> findByKeyword(@Param("keyword") String keyword);
	
	@Query(value = "select p.name, pvs.quantity, c.value, s.value as 'Size' from products p inner join product_variations pv on p.product_id = pv.product_id "
			+ "inner join product_variation_sizes pvs on pvs.product_variation_id = pvs.product_variation_id "
			+ "inner join colors c on c.color_id = pv.color_id "
			+ "inner join sizes s on s.size_id = pvs.size_id", nativeQuery = true)
	List<Object[]> getRepoOfProduct();
}
