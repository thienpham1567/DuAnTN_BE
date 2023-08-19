package shoesShop.common.Order;

import java.util.stream.Collectors;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.OrderLine.OrderLineConverter;
//import shoesShop.common.OrderLine.OrderLine;
//import shoesShop.common.OrderLine.OrderLineConverter;
import shoesShop.common.User.UserConverter;

public class OrderConverter  implements ICombiner<DbOrder>, IConverter<DbOrder, Order> {
	private UserConverter userConverter = new UserConverter();
	private OrderLineConverter orderLineConverter = new OrderLineConverter();
	
	
	@Override
	public void combine(DbOrder original, DbOrder update) {
		original.denormalizedAddress = update.denormalizedAddress;
		original.orderTotalPrice = update.orderTotalPrice;
		original.ordersStatus = update.ordersStatus;
		original.createdAt = update.createdAt;
		original.updatedAt = update.updatedAt;
		original.user = update.user;
	}

	@Override
	public DbOrder convertModelToDb(Order input) {
		return input == null ? null : new DbOrder(
					input.orderId,
					input.denormalizedAddress,
					input.orderTotalPrice,
					input.ordersStatus,
					input.createdAt,
					input.updatedAt,
					this.userConverter.convertModelToDb(input.user));
	}

	@Override
	public Order convertDbToModel(DbOrder input) {
		return input == null ? null
				: new Order(
						input.denormalizedAddress,
						input.orderTotalPrice,
						input.ordersStatus,
						input.createdAt,
						input.updatedAt,
						input.orderId,
						this.userConverter.convertDbToModel(input.user),
						input.orderLines.stream()
								.map(orderLine -> this.orderLineConverter.convertDbToModel(orderLine)).collect(Collectors.toList()));
	}
}
