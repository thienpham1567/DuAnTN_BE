package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.DbProduct;

public interface IProductRepository extends JpaRepository<DbProduct, Integer> {
}
