package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.DbOrderDetail;

public interface IOrderAddressRepository extends JpaRepository<DbOrderDetail, Integer> {

}
