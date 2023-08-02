package shoesShop.common.Order;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
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
	
	@Override
	public Collection<Order> retrieveAll() {
		Collection<Order> orders = this.load(null, null).stream()
				.map(dbOrder -> this.orderConverter.convertDbToModel(dbOrder)).collect(Collectors.toList());
		return orders;
	}

	public Collection<Order> retrieveAll(Integer userId) {
		Collection<Order> orders = this.load(null,userId).stream()
				.map(dbOrder -> this.orderConverter.convertDbToModel(dbOrder)).collect(Collectors.toList());
		return orders;
	}
	
//	public Collection<Order> retriveOrder(Integer userId) { 
//		Collection<DbOrder> dbOrder = this.orderRepo.findOrderIdByUserId(userId);
//		return this.orderConverter.convertDbToModel(dbOrder);
//	}
	
	@Override
	public Order retrieveOne(String id) {
		Order order = this.load(id, null).stream()
				.map(dbOrder -> this.orderConverter.convertDbToModel(dbOrder)).findFirst().get();
		return order;
	}

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

//	public Order updateOrderStatus(Order order, String id, String orderstatus) throws Exception{
//		DbOrder updateOrder = this.orderConverter.convertModelToDb(order);
//		updateOrder.updatedAt = LocalDateTime.now();
//		DbOrder dbOrder = this.orderRepo.findById(id).get();
//		if (dbOrder != null) {
//			this.orderConverter.combine(dbOrder, updateOrder);
//			DbOrder updateDbOrder = this.orderRepo.save(dbOrder);
//			return this.orderConverter.convertDbToModel(updateDbOrder);
//		}
//		return null;
//	}
	
//	public Order updateOrderStatus(String orderid, String orderstatus) throws Exception {
//        DbOrder dbOrder = this.orderRepo.findById(orderid).orElse(null);
//
//        if (dbOrder != null) {
//            // Cập nhật trạng thái đơn hàng và thời gian cập nhật
//            dbOrder.setOrdersStatus(orderstatus);
//            dbOrder.setUpdatedAt(LocalDateTime.now());
//
//            // Lưu đơn hàng đã cập nhật vào cơ sở dữ liệu
//            DbOrder updatedDbOrder = this.orderRepo.save(dbOrder);
//
//            // Chuyển đổi từ DbOrder đã cập nhật thành đối tượng Order và trả về
//            return this.orderConverter.convertDbToModel(updatedDbOrder);
//        } else {
//            // Xử lý trường hợp không tìm thấy đơn hàng với id cụ thể
//            throw new Exception("Không tìm thấy đơn hàng với ID " + orderid + ".");
//        }
//    }

}
