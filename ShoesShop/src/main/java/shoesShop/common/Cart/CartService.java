package shoesShop.common.Cart;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.Order.IOrderRepository;
import shoesShop.common.OrderLine.DbOrderLine;
import shoesShop.common.OrderLine.IOrderLineRepository;
import shoesShop.common.OrderLine.OrderLine;
import shoesShop.common.Product.Product;

@Service
public class CartService implements ICartService{
	@Autowired IOrderRepository orderRepo;
	
	@Autowired IOrderLineRepository orderDetailRepo;
	
	private HashMap<Integer, DbOrderLine> myOrder = new HashMap<>();

	@Override
	public void add(Integer quantity, Product entity) {
		
	}

	@Override
	public void remove(Integer productId) {
		
	}

	@Override
	public void update(Integer productId, Integer quantity) {
		
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
		return null;
	}

	@Override
	public Double getTotalAmount() {
		return null;
	}
	
}
