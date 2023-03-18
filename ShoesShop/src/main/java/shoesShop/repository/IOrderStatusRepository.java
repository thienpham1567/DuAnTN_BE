package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.DbOrderStatus;

public interface IOrderStatusRepository extends JpaRepository<DbOrderStatus, Integer> {
}
