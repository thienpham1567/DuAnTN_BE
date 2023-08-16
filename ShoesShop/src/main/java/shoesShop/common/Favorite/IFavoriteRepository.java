package shoesShop.common.Favorite;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IFavoriteRepository extends JpaRepository<DbFavorite, Integer>{
	@Query(value = "select * from favorites where user_id = ?1 and product_variation_id = ?2", nativeQuery = true)
	DbFavorite findByUsernameAndProductId(Integer userId, Integer productId);
}
