package shoesShop.common.Order;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<DbOrder, String> {
}
