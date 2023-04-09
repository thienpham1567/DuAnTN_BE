package shoesShop.common.Cart;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<DbCart, String>{
}
