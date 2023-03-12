package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{

}
