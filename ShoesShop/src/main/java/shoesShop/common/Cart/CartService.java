package shoesShop.common.Cart;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.CartItem.DbCartItem;
import shoesShop.common.CartItem.ICartItemRepository;
import shoesShop.common.OrderLine.OrderLine;
import shoesShop.common.ProductItem.ProductItem;

@Service
public class CartService implements ICartService{
	@Autowired ICartRepository cartRepo;
	
	@Autowired ICartItemRepository cartItemRepo;
	
	private HashMap<Integer, DbCartItem> cart = new HashMap<>();

	@Override
	public void add(Integer quantity, ProductItem entity) {
	}

	@Override
	public void remove(Integer productItemId) {
		
	}

	@Override
	public void update(Integer productItemId, Integer quantity) {
		
	}

	@Override
	public void clear() {
		
	}

	@Override
	public Collection<OrderLine> getOrder() {
		return null;
	}

	@Override
	public Integer getTotalQuantity() {
		return 0;
	}

	@Override
	public Double getSubTotalPrice() {
		return null;
	}
	
}
