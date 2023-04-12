package shoesShop.common.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface IUserRepository extends JpaRepository<DbUser, Integer> {
	@Query("SELECT a FROM DbUser a WHERE a.emailAddress = ?1")
	DbUser findByEmailAddress(String emailAddress);
}
