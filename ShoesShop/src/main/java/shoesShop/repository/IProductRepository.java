package shoesShop.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shoesShop.entity.DbProduct;

public interface IProductRepository extends JpaRepository<DbProduct, Integer> {
	@Query(value = "select * from Products s where s.Name like %:keyword%", nativeQuery = true)
	Collection<DbProduct> findByKeyword(@Param("keyword") String keyword);
}
