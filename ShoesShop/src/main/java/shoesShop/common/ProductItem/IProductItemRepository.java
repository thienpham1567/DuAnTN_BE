package shoesShop.common.ProductItem;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductItemRepository extends JpaRepository<DbProductItem, Integer> {
}
