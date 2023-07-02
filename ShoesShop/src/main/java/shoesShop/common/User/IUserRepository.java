package shoesShop.common.User;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

public interface IUserRepository extends JpaRepository<DbUser, Integer> {
	@Query("SELECT a FROM DbUser a WHERE a.emailAddress = ?1")
	DbUser findByEmailAddress(String emailAddress);
	
	@Query(value = "SELECT * FROM users u " +
            "INNER JOIN user_roles r ON u.user_id = r.user_id " +
            "WHERE r.role_id = ?1", nativeQuery = true)
	Collection<DbUser> getUsersWithAdmin(Integer id);
	
	@Query("SELECT u FROM DbUser u WHERE u.emailAddress LIKE %:search% OR u.firstName LIKE %:search% OR u.lastName LIKE %:search% OR u.phoneNumber LIKE %:search%")
	Collection<DbUser> searchUsers(@Param("search") String search);

	
}
