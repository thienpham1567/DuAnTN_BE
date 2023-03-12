package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.UserRole;

public interface IUserRoleRepository extends JpaRepository<UserRole, Integer>{
}
