package shoesShop.common.OrderLine;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.CartItem.DbCartItem;
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
//

//	
	public Collection<OrderLine> retrieveAll(String orderId) {
		Collection<OrderLine> orderLines = this.load(null, orderId, null, null).stream()
				.map(dbOrderLine -> this.converter.convertDbToModel(dbOrderLine)).collect(Collectors.toList());
		return orderLines;
	}
//
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
}
