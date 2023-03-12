package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.Brand;

public interface IBrandRepository extends JpaRepository<Brand, Integer>{

}
