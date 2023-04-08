package shoesShop.common.OrderLine;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderLineRepository extends JpaRepository<DbOrderLine, Integer> {
}
