package shoesShop.service;

import java.util.Collection;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.entity.DbOrderDetail;
import shoesShop.model.OrderDetail;
import shoesShop.model.Product;
import shoesShop.repository.IOrderDetailRepository;
import shoesShop.repository.IOrderRepository;

@Service
public class CartService implements ICartService{
	@Autowired IOrderRepository orderRepo;
	
	@Autowired IOrderDetailRepository orderDetailRepo;
	
	private HashMap<Integer, DbOrderDetail> myOrder = new HashMap<>();

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
	public Collection<OrderDetail> getOrder() {
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
