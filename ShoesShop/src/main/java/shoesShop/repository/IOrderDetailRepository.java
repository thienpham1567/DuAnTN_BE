package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.OrderDetail;

public interface IOrderDetailRepository extends JpaRepository<OrderDetail, Integer> {
}
