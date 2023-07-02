package shoesShop.common.Order;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.User.UserConverter;

public class OrderConverter  implements ICombiner<DbOrder>, IConverter<DbOrder, Order> {
	private UserConverter userConverter = new UserConverter();
	
	@Override
	public void combine(DbOrder original, DbOrder update) {
		original.user = update.user;
		original.denormalizedAddress = update.denormalizedAddress;
		original.orderTotalPrice = update.orderTotalPrice;
		original.ordersStatus = update.ordersStatus;
		original.createdAt = update.createdAt;
		original.updatedAt = update.updatedAt;
	}

	@Override
	public DbOrder convertModelToDb(Order input) {
		return input == null ? null : new DbOrder(
					input.denormalizedAddress,
					input.orderTotalPrice,
					input.ordersStatus,
					input.createdAt,
					input.updatedAt
				);
	}

	@Override
	public Order convertDbToModel(DbOrder input) {
		return input == null ? null : new Order(
					input.denormalizedAddress,
					input.orderTotalPrice,
					input.ordersStatus,
					input.createdAt,
					input.updatedAt,
					input.orderId,
					this.userConverter.convertDbToModel(input.user)
			);
	}
}
