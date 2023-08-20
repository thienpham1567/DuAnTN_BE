package shoesShop.common.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.api.payments.Payment;

import shoesShop.common.RecordManager;
import shoesShop.common.Address.DbAddress;
import shoesShop.common.Address.IAddressRepository;
import shoesShop.common.Brand.Brand;
import shoesShop.common.Brand.DbBrand;
import shoesShop.common.Cart.Cart;
import shoesShop.common.CartItem.CartItem;
import shoesShop.common.OrderLine.DbOrderLine;
import shoesShop.common.OrderLine.IOrderLineRepository;
import shoesShop.common.OrderLine.OrderLine;
import shoesShop.common.OrderLine.OrderLineConverter;
import shoesShop.common.OrderLine.OrderLineService;
import shoesShop.common.User.DbUser;
import shoesShop.common.User.IUserRepository;
import shoesShop.payment.PaymentRequest;

@Service
public class OrderService extends RecordManager<Order>{
	@Autowired
	private IOrderRepository orderRepo;
	
	@Autowired
	private IOrderLineRepository orderLineRepo;
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private IAddressRepository addressRepo;
	
	private OrderConverter orderConverter = new OrderConverter();
	private OrderLineConverter orderLineConverter = new OrderLineConverter();
	
	@Override
	public Collection<Order> retrieveAll() {
		Collection<Order> orders = this.load(null, null).stream()
				.map(dbOrder -> this.orderConverter.convertDbToModel(dbOrder)).collect(Collectors.toList());
		return orders;
	}

	public Collection<Order> retrieveOrder(Integer userId) {
		Collection<Order> orders = this.load(null,userId).stream()
				.map(dbOrder -> this.orderConverter.convertDbToModel(dbOrder)).collect(Collectors.toList());
		return orders;
	}
	
	public Order retrieveOne(String id) {
		Order order = this.orderRepo.findById(id).map(dbOrder -> this.orderConverter.convertDbToModel(dbOrder)).orElse(null);
		return order;
	}
	
	@Override
	public Order update(Order order, String id) throws Exception {
		DbOrder updateOrder = this.orderConverter.convertModelToDb(order);
		updateOrder.user = this.userRepo.findById(order.user.userId).get();
		updateOrder.address = this.addressRepo.findById(order.addressId).get();
		DbOrder dbOrder = this.orderRepo.findById(id).get();
		if (dbOrder != null) {
			this.orderConverter.combine(dbOrder, updateOrder);
			DbOrder updateDbOrder = this.orderRepo.save(dbOrder);
			return this.orderConverter.convertDbToModel(updateDbOrder);
		}
		return null;
	}


	private Collection<DbOrder> load(String orderId, Integer userId) {
	    Collection<DbOrder> dbOrders = this.orderRepo.findAll();

	    if (orderId != null) {
	        dbOrders = dbOrders.stream()
	            .filter(dbOrder -> dbOrder.getOrderId().equals(orderId))
	            .collect(Collectors.toList());
	    }
	    if (userId != null) {
	        dbOrders = dbOrders.stream()
	            .filter(dbOrder -> dbOrder.getUser() != null && dbOrder.getUser().getUserId().equals(userId))
	            .collect(Collectors.toList());
	    }
	    return dbOrders;
	}

	
//	@Override
//	public Order create(Order order) {
//	    // Chuyển đổi Order sang DbOrder
//	    DbOrder dbOrder = this.orderConverter.convertModelToDb(order);
//
//	    // Tìm và gán DbUser tương ứng cho dbOrder
//	    DbUser dbUser = this.userRepo.findById(order.user.userId).get();
////	    DbUser dbUser = this.userRepo.findById(order.getUser().getUserId()).orElse(null);
//	    if (dbUser != null) {
//	        dbOrder.setUser(dbUser);
//	    }
//
//	    // Lưu dbOrder vào cơ sở dữ liệu
//	    DbOrder createdDbOrder = this.orderRepo.save(dbOrder);
//
//	    // Chuyển đổi danh sách OrderLine sang danh sách DbOrderLine và lưu vào cơ sở dữ liệu
//	    List<DbOrderLine> dbOrderLines = new ArrayList<>();
//	    for (OrderLine orderLine : order.getOrderLines()) {
//	        DbOrderLine dbOrderLine = this.orderLineConverter.convertModelToDb(orderLine);
//	        dbOrderLine.setOrder(createdDbOrder);  // Gán DbOrder cho DbOrderLine
//	        dbOrderLines.add(dbOrderLine);
//	    }
//	    List<DbOrderLine> savedDbOrderLines = this.orderLineRepo.saveAll(dbOrderLines);
//	    System.out.println(savedDbOrderLines);
//	    // Chuyển đổi createdDbOrder thành Order và trả về
//	    Order createdOrder = this.orderConverter.convertDbToModel(createdDbOrder);
//	    createdOrder.setOrderLiness(savedDbOrderLines.stream()
//	                                .map(this.orderLineConverter::convertDbToModel)
//	                                .collect(Collectors.toList()));
//	    return createdOrder;
//	}

	
	@Override
	public Order create(Order order) {
		DbOrder dbOrder = this.orderConverter.convertModelToDb(order);
		DbUser dbUser = this.userRepo.findById(order.user.userId).get();
		if (dbUser != null) {
	        dbOrder.setUser(dbUser);
	    }
//		dbOrder.user = dbUser;
		DbOrder createdOrder = this.orderRepo.save(dbOrder);
		return this.orderConverter.convertDbToModel(createdOrder);
	}
	
	
	
	public Order createOrderFromCart(PaymentRequest paymentRequest) {
		Order order = new Order();

	    order.setAddressId(paymentRequest.addressId);
	    order.setOrderId(paymentRequest.cart.getCartId());
	    order.setOrderTotalPrice(paymentRequest.cart.getItemSubtotalPrice());
	    order.setOrdersStatus("Chưa xử lý");
	    order.setCreatedAt(LocalDateTime.now());
	    order.setUser(paymentRequest.cart.getUser());
	    
	    List<OrderLine> orderLines = new ArrayList<>();
	    for (CartItem cartItem : paymentRequest.cart.getCartItems()) {
	        OrderLine orderLine = new OrderLine();
	        // Gán thông tin cho đối tượng OrderLine
	        orderLine.setOrderId(cartItem.getCartId());
            orderLine.setPrice(cartItem.getPrice());
            orderLine.setQuantity(cartItem.getQuantity());
            orderLine.setProductVariationSize(cartItem.getProductVariationSize());
            orderLine.setImageUrl(cartItem.getImageUrl());
            orderLine.setColor(cartItem.getColor());
	        orderLines.add(orderLine);
	    }
	    
	    order.setOrderLines(paymentRequest.cart.getCartItems()); // Ánh xạ các CartItem thành OrderLine
	    return order;
	}

	public Order updateOrderStatus(Order order, String id, String orderstatus) throws Exception{
		DbOrder updateOrder = this.orderConverter.convertModelToDb(order);
		updateOrder.updatedAt = LocalDateTime.now();
		DbOrder dbOrder = this.orderRepo.findById(id).get();
		if (dbOrder != null) {
			this.orderConverter.combine(dbOrder, updateOrder);
			DbOrder updateDbOrder = this.orderRepo.save(dbOrder);
			return this.orderConverter.convertDbToModel(updateDbOrder);
		}
		return null;
	}
	
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

	
	
//	public Order createOrderFromCart(Payment paymentRequest) {
//	    Order order = new Order();
//	    order.setDenormalizedAddress(paymentRequest.());
//	    order.setOrderId(paymentRequest.cart.getCartId());
//	    order.setOrderTotalPrice(paymentRequest.cart.getItemSubtotalPrice());
//	    order.setOrdersStatus("Chưa xử lý");
//	    order.setCreatedAt(LocalDateTime.now());
//	    order.setUser(paymentRequest.cart.getUser());
//	    
//	    List<OrderLine> orderLines = new ArrayList<>();
//	    for (CartItem cartItem : paymentRequest.cart.getCartItems()) {
//	        OrderLine orderLine = new OrderLine();
//	        // Gán thông tin cho đối tượng OrderLine
//	        orderLine.setOrderId(cartItem.getCartId());
//            orderLine.setPrice(cartItem.getPrice());
//            orderLine.setQuantity(cartItem.getQuantity());
//            orderLine.setProductVariationSize(cartItem.getProductVariationSize());
//            orderLine.setImageUrl(cartItem.getImageUrl());
//            orderLine.setColor(cartItem.getColor());
//	        orderLines.add(orderLine);
//	    }
//	    
//	    order.setOrderLines(paymentRequest.cart.getCartItems()); // Ánh xạ các CartItem thành OrderLine
//	    return order;
//	}
}
