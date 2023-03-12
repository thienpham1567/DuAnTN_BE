package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
}
