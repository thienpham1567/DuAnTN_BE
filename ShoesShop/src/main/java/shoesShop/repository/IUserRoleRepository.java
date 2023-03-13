package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import shoesShop.entity.DbUserRole;

public interface IUserRoleRepository extends JpaRepository<DbUserRole, Integer>{
}
