package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.DbOrderLine;

public interface IOrderAddressRepository extends JpaRepository<DbOrderLine, Integer> {

}
