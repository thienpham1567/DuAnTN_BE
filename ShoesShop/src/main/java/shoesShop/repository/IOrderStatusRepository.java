package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.OrderStatus;

public interface IOrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
}
