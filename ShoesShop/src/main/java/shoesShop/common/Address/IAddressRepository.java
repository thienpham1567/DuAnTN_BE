package shoesShop.common.Address;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.common.OrderLine.DbOrderLine;

public interface IAddressRepository extends JpaRepository<DbOrderLine, Integer> {

}
