package shoesShop.common.CartItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartItemRepository extends JpaRepository<DbCartItem, Integer> {
}
