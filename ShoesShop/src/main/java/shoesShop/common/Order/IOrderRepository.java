package shoesShop.common.Order;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IOrderRepository extends JpaRepository<DbOrder, String> {
	@Query(value = "select * from orders where user_id = ?1", nativeQuery = true)
	Collection<DbOrder> findOrderIdByUserId(Integer userId);
}
