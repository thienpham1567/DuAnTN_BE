package shoesShop.common.OrderLine;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.Cart.CartConverter;
import shoesShop.common.Order.OrderConverter;

public class OrderLineConverter implements ICombiner<DbOrderLine>, IConverter<DbOrderLine, OrderLine>{
	private OrderConverter orderConverter = new OrderConverter();
//	private CartConverter cartConverter = new CartConverter();
	
	@Override
	public void combine(DbOrderLine original, DbOrderLine update) {
		original.price = update.price;
		original.quantity = update.quantity;
	}

	@Override
	public DbOrderLine convertModelToDb(OrderLine input) {
		return input == null ? null : new DbOrderLine(input.price, input.quantity);
	}

	@Override
	public OrderLine convertDbToModel(DbOrderLine input) {
		return input == null ? null : new OrderLine(
					input.price,
					input.quantity,
					input.order.orderId,
					input.orderLineId,
					input.productItem.productItemId
				);
	}


}
