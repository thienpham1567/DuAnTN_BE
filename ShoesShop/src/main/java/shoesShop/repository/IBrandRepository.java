package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.DbBrand;

public interface IBrandRepository extends JpaRepository<DbBrand, Integer> {
}
