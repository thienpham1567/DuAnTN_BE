package shoesShop.common.OrderLine;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
//import shoesShop.common.Order.IOrderRepository;
//import shoesShop.common.Product.IProductRepository;
//import shoesShop.common.ProductItem.IProductItemRepository;
//import shoesShop.common.OrderLine.DbOrderLine;
//import shoesShop.common.OrderLine.IOrderLineRepository;
//import shoesShop.common.OrderLine.OrderLine;
//import shoesShop.common.OrderLine.OrderLineConverter;

@Service
public class OrderLineService  extends RecordManager<OrderLine> {
	@Autowired
	IOrderLineRepository orderLineRepo;

//	@Autowired
//	IProductRepository productRepo;
//
//	@Autowired
//	IOrderRepository orderRepo;

	OrderLineConverter converter = new OrderLineConverter();
	
	// Thống kê nhản hiệu bán chạy.
	
	
	@Override
	public Collection<OrderLine> retrieveAll() {
		Collection<OrderLine> orderLines = this.load(null, null).stream()
				.map(dbOrderLine -> this.converter.convertDbToModel(dbOrderLine)).collect(Collectors.toList());
		return orderLines;
	}

//	@Override
//	public OrderLine create(OrderLine orderLine) throws Exception {
//		DbOrderLine dbOrderLine = this.converter.convertModelToDb(orderLine);
//		dbOrderLine.order = this.orderRepo.findById(orderLine.orderId).get();
//		dbOrderLine.productItem = this.productItemRepo.findById(orderLine.productItemId).get();
//		DbOrderLine createdOrderLine = this.orderLineRepo.save(dbOrderLine);
//		return this.converter.convertDbToModel(createdOrderLine);
//	}
//
//	@Override
//	public OrderLine retrieveOne(Integer id) {
//		OrderLine orderLine = this.load(id, null, null).stream()
//				.map(dbOrderLine -> this.converter.convertDbToModel(dbOrderLine)).findFirst().get();
//		return orderLine;
//	}
//	
//	public Collection<OrderLine> retrieveAll(Integer productitemId, String orderId) {
//		Collection<OrderLine> orderLines = this.load(null, productitemId, orderId).stream()
//				.map(dbOrderLine -> this.converter.convertDbToModel(dbOrderLine)).collect(Collectors.toList());
//		return orderLines;
//	}
//
	private Collection<DbOrderLine> load(Integer orderLineId, String orderId) {
		Collection<DbOrderLine> dbOrderLines = this.orderLineRepo.findAll();

		if (orderLineId != null) {
			dbOrderLines = dbOrderLines.stream()
					.filter(dbOrderLine -> dbOrderLine.orderLineId == orderLineId).collect(Collectors.toList());
		}


//		if (productitemId != null) {
//			dbOrderLines = dbOrderLines.stream()
//					.filter(dbOrderLine -> dbOrderLine.productItem.productItemId == productitemId)
//					.collect(Collectors.toList());
//		}

		if (orderId != null) {
			dbOrderLines = dbOrderLines.stream()
					.filter(dbOrderLine -> dbOrderLine.order.orderId == orderId)
					.collect(Collectors.toList());
		}

		return dbOrderLines;
	}
}
