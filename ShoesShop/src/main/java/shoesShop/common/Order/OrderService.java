package shoesShop.common.Order;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import shoesShop.common.RecordManager;
import shoesShop.common.Cart.Cart;
import shoesShop.common.Cart.DbCart;
import shoesShop.common.OrderLine.OrderLine;
import shoesShop.common.OrderLine.OrderLineService;
import shoesShop.common.User.IUserRepository;

@Service
public class OrderService extends RecordManager<Order>{
	@Autowired
	private IOrderRepository orderRepo;
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired 
	private OrderLineService orderLineService;
	
	private OrderConverter orderConverter = new OrderConverter();
	
//	private HashMap<String, OrderLine> orderLine = new HashMap<>();

	@Override
	public Collection<Order> retrieveAll() {
		Collection<Order> orders = this.load(null, null).stream()
				.map(dbOrder -> this.orderConverter.convertDbToModel(dbOrder)).collect(Collectors.toList());
		return orders;
	}

	public Collection<Order> retrieveAll(Integer userId) {
		Collection<Order> orders = this.load(null,userId).stream()
				.map(dbProduct -> this.orderConverter.convertDbToModel(dbProduct)).collect(Collectors.toList());
		return orders;
	}
	
//	public Collection<Order> retriveOrder(Integer userId) { 
//		Collection<DbOrder> dbOrder = this.orderRepo.findOrderIdByUserId(userId);
//		return this.orderConverter.convertDbToModel(dbOrder);
//	}
	
	@Override
	public Order retrieveOne(String id) {
		Order order = this.load(id, null).stream()
				.map(dbProduct -> this.orderConverter.convertDbToModel(dbProduct)).findFirst().get();
		return order;
	}
//	@Override
//	public Double getOrderTotalPrice(String orderId) {
//		Collection<OrderLine> items = this.orderLineService.retrieveAll(orderId);
//		return items.stream().map(OrderLine::getPrice).reduce(0.0, Double::sum);
//	}





	private Collection<DbOrder> load(String orderId, Integer userId) {
		Collection<DbOrder> dbOrders = this.orderRepo.findAll();

		if (orderId != null) {
			dbOrders = dbOrders.stream().filter(dbOrder -> dbOrder.orderId == orderId)
					.collect(Collectors.toList());
		}
		if (userId != null) {
			dbOrders = dbOrders.stream().filter(dbOrder -> dbOrder.user.userId == userId)
					.collect(Collectors.toList());
		}
		return dbOrders;
	}


}
