package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.DbRole;

public interface IRoleRepository extends JpaRepository<DbRole, Integer> {
}
