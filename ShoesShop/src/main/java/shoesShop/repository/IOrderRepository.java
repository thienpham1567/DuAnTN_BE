package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.DbOrder;

public interface IOrderRepository extends JpaRepository<DbOrder, Integer> {
}
