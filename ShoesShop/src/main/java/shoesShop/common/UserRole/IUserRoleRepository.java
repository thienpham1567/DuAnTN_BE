package shoesShop.common.UserRole;

import java.util.Collection;
import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface IUserRoleRepository extends JpaRepository<DbUserRole, Integer>{
	
//	@Transactional
//    @Modifying
//    @Query("DELETE FROM DbUserRole u WHERE u.userId = ?1")
//    void deleteAllByUserId(Integer userId);
	
	@Query("SELECT ur FROM DbUserRole ur WHERE ur.user.userId = :userId")
	Collection<DbUserRole> findByUserId(@Param("userId") Integer userId);
}
