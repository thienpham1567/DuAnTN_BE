package shoesShop.common.OrderLine;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;


public class OrderLineConverter implements ICombiner<DbOrderLine>, IConverter<DbOrderLine, OrderLine>{

	@Override
	public DbOrderLine convertModelToDb(OrderLine input) {
		
		return input == null ? null : new DbOrderLine(
				input.detailPrice,
				input.quantity
				);
	}

	@Override
	public OrderLine convertDbToModel(DbOrderLine input) {
		// TODO Auto-generated method stub
		return input == null ? null : new OrderLine(
				input.price,
				input.quantity,
				input.orderLineId,
				input.productItem.productItemId,
				input.order.orderId
				);
	}

	@Override
	public void combine(DbOrderLine original, DbOrderLine update) {
		original.order = update.order;
		original.productItem = update.productItem;
		original.price = update.price;
		original.quantity = update.quantity;
		
	}

}
