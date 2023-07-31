package shoesShop.common.Order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrderRepository extends JpaRepository<DbOrder, String> {
	// Thống kê Top 5 khách hàng
	@Query(value = "select count(o.order_id), concat(u.first_name, ' ', u.last_name) from orders o inner join users u on o.user_id = u.user_id "
			+ "group by (concat(u.first_name, ' ', u.last_name)) order by count(o.order_id) desc limit 5	", nativeQuery = true)
	List<Object[]> getReportTopUser();
}
