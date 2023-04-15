package shoesShop.common.ProductItem;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IProductItemRepository extends JpaRepository<DbProductItem, Integer> {
	@Query("SELECT pi FROM DbProductItem pi INNER JOIN pi.product p WHERE p.name like %:keyword%")
	Collection<DbProductItem> getProductItemsByProductName(@Param("keyword") String keyword);
}
