package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.Category;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
