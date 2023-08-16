package shoesShop.common.Product;

import java.util.List;

public interface IProductInventoryService {
	// Danh sách Product quantity
		List<Object[]> getProductInventory();
}
