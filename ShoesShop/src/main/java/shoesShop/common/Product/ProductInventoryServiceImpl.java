package shoesShop.common.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInventoryServiceImpl implements IProductInventoryService{
	@Autowired
	IProductRepository repo;

	@Override
	public List<Object[]> getProductInventory() {
		return repo.getRepoOfProduct();
	}
	
	
}
