package shoesShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import shoesShop.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
}
