package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shoesShop.entity.DbUser;

public interface IUserRepository extends JpaRepository<DbUser, Integer> {
}
