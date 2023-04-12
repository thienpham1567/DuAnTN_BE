package shoesShop.common.Role;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRoleRepository extends JpaRepository<DbRole, Integer> {
	@Query("SELECT r FROM DbUserRole ur JOIN ur.role r WHERE ur.user.id = ?1")
	List<DbRole> findRoleByUserId(Integer id);
}
