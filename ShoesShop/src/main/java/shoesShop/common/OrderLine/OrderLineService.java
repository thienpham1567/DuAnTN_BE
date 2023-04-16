package shoesShop.common.OrderLine;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.Order.IOrderRepository;
import shoesShop.common.Product.DbProduct;
import shoesShop.common.Product.Product;
import shoesShop.common.ProductItem.IProductItemRepository;
@Service
public class OrderLineService extends RecordManager<OrderLine>{
	@Autowired
	private IOrderLineRepository orderLineRepo;
	@Autowired
	private IProductItemRepository productItemRepo;
	@Autowired
	private IOrderRepository orderRepo;
	
	OrderLineConverter converter = new OrderLineConverter();
	@Override
	public Collection<OrderLine> retrieveAll() throws Exception {
		Collection<OrderLine> orderLines = this.load(null, null, null).stream()
				.map(dbOrderLine -> this.converter.convertDbToModel(dbOrderLine)).collect(Collectors.toList());
		return orderLines;
	}

	@Override
	public OrderLine retrieveOne(Integer id) throws Exception {
		OrderLine orderLine = this.load(id, null, null).stream()
				.map(dbOrderLine -> this.converter.convertDbToModel(dbOrderLine)).findFirst().get();
		return orderLine;
	}

	@Override
	public OrderLine create(OrderLine orderLine) throws Exception {
		DbOrderLine dbOrderLine = this.converter.convertModelToDb(orderLine);
		dbOrderLine.order = this.orderRepo.findById(orderLine.orderId).get();
		dbOrderLine.productItem = this.productItemRepo.findById(orderLine.productItemId).get();
		DbOrderLine createdOrderLine = this.orderLineRepo.save(dbOrderLine);
		return this.converter.convertDbToModel(createdOrderLine);
	}
	
	
	private Collection<DbOrderLine> load(Integer orderLineId, Integer productItemId, String orderId) {
		Collection<DbOrderLine> dbOrderLines = this.orderLineRepo.findAll();

		if (orderLineId != null) {
			dbOrderLines = dbOrderLines.stream().filter(dbOrderLine -> dbOrderLine.orderLineId == orderLineId)
					.collect(Collectors.toList());
		}

		if (productItemId != null && orderId != null) {
			return dbOrderLines = dbOrderLines.stream().filter(
					dbOrderLine -> dbOrderLine.productItem.productItemId == productItemId && dbOrderLine.order.orderId == orderId)
					.collect(Collectors.toList());
		}

		if (productItemId != null) {
			dbOrderLines = dbOrderLines.stream().filter(dbOrderLine -> dbOrderLine.productItem.productItemId == productItemId)
					.collect(Collectors.toList());
		}

		if (orderId != null) {
			dbOrderLines = dbOrderLines.stream().filter(dbOrderLine -> dbOrderLine.order.orderId == orderId)
					.collect(Collectors.toList());
		}

		return dbOrderLines;
	}
}
