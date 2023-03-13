package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.DbCategory;

public interface ICategoryRepository extends JpaRepository<DbCategory, Integer> {
}
