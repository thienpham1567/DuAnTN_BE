package shoesShop.converter;

import shoesShop.entity.DbOrderStatus;
import shoesShop.model.OrderStatus;

public class OrderStatusConverter implements ICombiner<DbOrderStatus>, IConverter<DbOrderStatus, OrderStatus> {
	@Override
	public void combine(DbOrderStatus original, DbOrderStatus update) {
		original.setDescription(update.getDescription());
	}

	@Override
	public DbOrderStatus convertModelToDb(OrderStatus input) {
		return input == null ? null : new DbOrderStatus(input.description, input.created);
	}

	@Override
	public OrderStatus convertDbToModel(DbOrderStatus input) {
		return input == null ? null : new OrderStatus(input.orderStatusId, input.description);
	}
}
