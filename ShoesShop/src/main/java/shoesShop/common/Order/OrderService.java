package shoesShop.common.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.Address.DbAddress;
import shoesShop.common.Address.IAddressRepository;
import shoesShop.common.CartItem.CartItem;
import shoesShop.common.OrderLine.IOrderLineRepository;
import shoesShop.common.OrderLine.OrderLine;
import shoesShop.common.OrderLine.OrderLineConverter;
import shoesShop.common.User.DbUser;
import shoesShop.common.User.IUserRepository;
import shoesShop.common.User.User;
import shoesShop.common.User.UserConverter;
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
	private UserConverter userConverter = new UserConverter();
	
	@Override
	public Collection<Order> retrieveAll() {
		Collection<Order> orders = this.load(null, null, null).stream()
				.map(dbOrder -> this.orderConverter.convertDbToModel(dbOrder)).collect(Collectors.toList());
		return orders;
	}

	public Collection<Order> retrieveOrder(Integer userId) {
		Collection<Order> orders = this.load(null,userId,null).stream()
				.map(dbOrder -> this.orderConverter.convertDbToModel(dbOrder)).collect(Collectors.toList());
		return orders;
	}
	
	public Order retrieveOne(String id) {
		Order order = this.orderRepo.findById(id).map(dbOrder -> this.orderConverter.convertDbToModel(dbOrder)).orElse(null);
		return order;
	}
	
	private Collection<DbOrder> load(String orderId, Integer userId, Integer addressId) {
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
	    if (addressId != null) {
	        dbOrders = dbOrders.stream()
	        		.filter(dbOrder -> dbOrder.getAddress() != null && dbOrder.getAddress().getAddressId().equals(addressId))
	            .collect(Collectors.toList());
	    }
	    return dbOrders;
	}
	
	@Override
	public Order create(Order order) {
		DbOrder dbOrder = this.orderConverter.convertModelToDb(order);
		DbUser dbUser = this.userRepo.findById(order.user.userId).get();
		DbAddress dbAddress = this.addressRepo.findById(order.addressId).get();
		if (dbUser != null) {
	        dbOrder.setUser(dbUser);
	        dbOrder.setAddress(dbAddress);
	    }
		DbOrder createdOrder = this.orderRepo.save(dbOrder);
		return this.orderConverter.convertDbToModel(createdOrder);
	}
	
	public Order createOrderFromCart(PaymentRequest paymentRequest) {
		Order order = new Order();

	    order.setAddressId(paymentRequest.addressId);
	    order.setOrderId(paymentRequest.cart.getCartId());
	    order.setOrderTotalPrice(paymentRequest.cart.getItemSubtotalPrice());
	    order.setOrdersStatus("Đang xử lý");
	    order.setCreatedAt(LocalDateTime.now());
	    
	    DbUser dbUser = this.userRepo.findById(paymentRequest.userId).get();
	    User user = this.userConverter.convertDbToModel(dbUser);
	    order.setUser(user);   
	    
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

	@Override
	public Order update(Order order, String orderid) throws Exception {
		DbOrder updateOrder = this.orderConverter.convertModelToDb(order);
		updateOrder.updatedAt = LocalDateTime.now();
		DbOrder dbOrder = this.orderRepo.findById(orderid).get();
		if (dbOrder != null) {
			this.orderConverter.combine(dbOrder, updateOrder);
			DbOrder updateDbOrder = this.orderRepo.save(dbOrder);
			return this.orderConverter.convertDbToModel(updateDbOrder);
		}
		return null;
	}
}
