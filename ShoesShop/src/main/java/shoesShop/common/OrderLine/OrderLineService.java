package shoesShop.common.OrderLine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.Cart.Cart;
import shoesShop.common.Cart.CartService;
import shoesShop.common.CartItem.CartItem;
import shoesShop.common.Color.IColorRepository;
import shoesShop.common.Order.IOrderRepository;
import shoesShop.common.ProductVariationSizes.IProductVariationSizeRepository;
//import shoesShop.common.Order.IOrderRepository;
//import shoesShop.common.Product.IProductRepository;
//import shoesShop.common.ProductItem.IProductItemRepository;
//import shoesShop.common.OrderLine.DbOrderLine;
//import shoesShop.common.OrderLine.IOrderLineRepository;
//import shoesShop.common.OrderLine.OrderLine;
//import shoesShop.common.OrderLine.OrderLineConverter;
import shoesShop.common.Size.ISizeRepository;

@Service
public class OrderLineService  extends RecordManager<OrderLine> {
	@Autowired
	private IOrderLineRepository orderLineRepo;

	@Autowired
	private IOrderRepository orderRepo;
	
	@Autowired
	private IColorRepository colorRepo;
	
	@Autowired
	private IProductVariationSizeRepository pvsRepo;

	@Autowired
	private ISizeRepository sizeRepo;
	
	@Autowired 
	CartService cartService;

	OrderLineConverter converter = new OrderLineConverter();
	
	@Override
	public Collection<OrderLine> retrieveAll() {
		Collection<OrderLine> orderLines = this.load(null, null, null, null).stream()
				.map(dbOrderLine -> this.converter.convertDbToModel(dbOrderLine)).collect(Collectors.toList());
		return orderLines;
	}

	@Override
	public OrderLine retrieveOne(Integer id) {
		OrderLine orderLine = this.load(id, null, null, null).stream().map(dbOrderLine -> this.converter.convertDbToModel(dbOrderLine)).findFirst().get();
		return orderLine;
	}
	
	
	public Collection<OrderLine> createOrderLineFromCartItems(String cartId) {
	    // Lấy thông tin giỏ hàng dựa trên cartId
	    Cart cart = cartService.retriveCart(cartId);

	    // Lấy danh sách các CartItem từ giỏ hàng
	    Collection<CartItem> cartItems = cart.getCartItems();

	    // Tạo danh sách để lưu các OrderLine
	    Collection<OrderLine> orderLines = new ArrayList<>();

	    // Duyệt qua từng CartItem và tạo OrderLine tương ứng
	    for (CartItem cartItem : cartItems) {
	        OrderLine orderLine = new OrderLine();
	        orderLine.setOrderId(cartItem.getCartId());
	        orderLine.setPrice(cartItem.getPrice());
	        orderLine.setQuantity(cartItem.getQuantity());
	        orderLine.setProductVariationSize(cartItem.getProductVariationSize());
	        orderLine.setImageUrl(cartItem.getImageUrl());
	        orderLine.setColor(cartItem.getColor());

	        orderLines.add(orderLine);
	    }

	    return orderLines;
	}

	
	@Override
	public OrderLine create(OrderLine orderLine) throws Exception {
		DbOrderLine dbOrderLine = this.converter.convertModelToDb(orderLine);
		dbOrderLine.imageUrl = orderLine.imageUrl;
		dbOrderLine.quantity = orderLine.quantity;
		dbOrderLine.color = this.colorRepo.findById(orderLine.color.colorId).get();
		dbOrderLine.price = orderLine.productVariationSize.productVariation.product.price * orderLine.quantity;
		dbOrderLine.order = this.orderRepo.findById(orderLine.orderId).get();
		dbOrderLine.productVariationSize = this.pvsRepo.findById(orderLine.productVariationSize.productVariationSizeId)
				.get();
		DbOrderLine createdOrderLine = this.orderLineRepo.save(dbOrderLine);
		return this.converter.convertDbToModel(createdOrderLine);
	}

	public Collection<OrderLine> retrieveAll(String orderId) {
		Collection<OrderLine> orderLines = this.load(null, orderId, null, null).stream()
				.map(dbOrderLine -> this.converter.convertDbToModel(dbOrderLine)).collect(Collectors.toList());
		return orderLines;
	}
	
	private Collection<DbOrderLine> load(Integer orderLineId, String orderId, Integer productVariationSizeId, Integer colorId) {
		Collection<DbOrderLine> dbOrderLines = this.orderLineRepo.findAll();

		if (orderLineId != null) {
			dbOrderLines = dbOrderLines.stream()
					.filter(dbOrderLine -> dbOrderLine.orderLineId == orderLineId).collect(Collectors.toList());
		}

		if (orderId != null) {
			dbOrderLines = dbOrderLines.stream()
					.filter(dbOrderLine -> dbOrderLine.order.orderId == orderId)
					.collect(Collectors.toList());
		}
		
		if (productVariationSizeId != null && colorId != null) {
			dbOrderLines = dbOrderLines.stream()
					.filter(dbOrderLine -> dbOrderLine.productVariationSize.productVariationSizeId.intValue() == productVariationSizeId.intValue() && dbOrderLine.color.colorId.intValue() == colorId.intValue())
					.collect(Collectors.toList());
		}
		return dbOrderLines;
	}
	
	public Collection<OrderLine> createOrderLinesFromCartItems(Collection<CartItem> collection) {
        Collection<OrderLine> orderLines = new ArrayList<>();

        for (CartItem cartItem : collection) {
            OrderLine orderLine = new OrderLine();
            orderLine.setOrderId(cartItem.getCartId());
            orderLine.setPrice(cartItem.getPrice());
            orderLine.setQuantity(cartItem.getQuantity());
            orderLine.setProductVariationSize(cartItem.getProductVariationSize());
            orderLine.setImageUrl(cartItem.getImageUrl());
            orderLine.setColor(cartItem.getColor());

            orderLines.add(orderLine);
        }

        return orderLines;
    }
	
    @Transactional
    public Collection<DbOrderLine> createDbOrderLinesFromOrderLines(Collection<OrderLine> orderLines) {
        Collection<DbOrderLine> dbOrderLines = new ArrayList<>();

        for (OrderLine orderLine : orderLines) {
            DbOrderLine dbOrderLine = converter.convertModelToDb(orderLine);
            dbOrderLine.imageUrl = orderLine.imageUrl;
            dbOrderLine.quantity = orderLine.quantity;
            dbOrderLine.color.colorId = orderLine.color.colorId;
            dbOrderLine.price = orderLine.price;
            dbOrderLine.order.orderId = orderLine.orderId;
            dbOrderLine.productVariationSize.productVariationSizeId = orderLine.productVariationSize.productVariationSizeId;

            dbOrderLines.add(dbOrderLine);
        }

        return orderLineRepo.saveAll(dbOrderLines);
    }
	
//	public void setOrderLines(Collection<CartItem> cartItems) {
//	    List<OrderLine> orderLines = cartItems.stream()
//	            .map(cartItem -> new OrderLine(
//	                this.orderId, // Sử dụng orderId của Order
//	                cartItem.getPrice(),
//	                cartItem.getQuantity(),
//	                cartItem.getProductVariationSize(),
//	                cartItem.getColor()
//	            ))
//	            .collect(Collectors.toList());
//	    
//	    this.orderLines = orderLines;
//	}
    
//	public List<DbOrderLine> createDbOrderLinesFromOrderLines(List<OrderLine> orderLines) {
//	    List<DbOrderLine> dbOrderLines = new ArrayList<>();
//	    for (OrderLine orderLine : orderLines) {
//	        DbOrderLine dbOrderLine = new DbOrderLine();
//	        dbOrderLine.setOrder(orderLine.getOrderId());
//	        dbOrderLine.setPrice(orderLine.getPrice());
//	        dbOrderLine.setQuantity(orderLine.getQuantity());
//	        dbOrderLine.setProductVariationSize(orderLine.getProductVariationSize());
//	        dbOrderLine.setImageUrl(orderLine.getImageUrl());
//	        dbOrderLine.setColor(orderLine.getColor());
//	        // Gán các thông tin khác từ orderLine sang dbOrderLine
//
//	        dbOrderLines.add(dbOrderLine);
//	    }
//	    return dbOrderLines;
//	}

}
