package shoesShop.common.Order;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.User.IUserRepository;

@Service
public class OrderService extends RecordManager<Order>{
	@Autowired
	private IOrderRepository orderRepo;
	
	@Autowired
	private IUserRepository userRepo;
	
	OrderConverter converter = new OrderConverter();
	
	@Override
	public Collection<Order> retrieveAll() {
		Collection<Order> orders = this.load(null, null).stream()
				.map(dbOrder -> this.converter.convertDbToModel(dbOrder)).collect(Collectors.toList());
		return orders;
	}

	@Override
	public Order retrieveOne(String id) {
		Order order = this.load(id, null).stream()
				.map(dbProduct -> this.converter.convertDbToModel(dbProduct)).findFirst().get();
		return order;
	}



	public Collection<Order> retrieveAll(Integer orderId, Integer userId) {
		Collection<Order> products = this.load(null,userId).stream()
				.map(dbProduct -> this.converter.convertDbToModel(dbProduct)).collect(Collectors.toList());
		return products;
	}

	private Collection<DbOrder> load(String orderId, Integer userId) {
		Collection<DbOrder> dbOrders = this.orderRepo.findAll();

		if (orderId != null) {
			dbOrders = dbOrders.stream().filter(dbOrder -> dbOrder.orderId == orderId)
					.collect(Collectors.toList());
		}

//		if (brandId != null && categoryId != null) {
//			return dbProducts = dbProducts.stream().filter(
//					dbProduct -> dbProduct.brand.brandId == brandId && dbProduct.category.categoryId == categoryId)
//					.collect(Collectors.toList());
//		}

		if (userId != null) {
			dbOrders = dbOrders.stream().filter(dbOrder -> dbOrder.user.userId == userId)
					.collect(Collectors.toList());
		}

//		if (categoryId != null) {
//			dbProducts = dbProducts.stream().filter(dbProduct -> dbProduct.category.categoryId == categoryId)
//					.collect(Collectors.toList());
//		}

		return dbOrders;
	}
}
