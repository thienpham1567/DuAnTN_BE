package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.Order;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
}
