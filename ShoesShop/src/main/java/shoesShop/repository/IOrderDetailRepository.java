package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.DbOrderLine;

public interface IOrderDetailRepository extends JpaRepository<DbOrderLine, Integer> {
}
