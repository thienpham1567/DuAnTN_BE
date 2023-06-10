//package shoesShop.common.Order;
//
//import shoesShop.common.ICombiner;
//import shoesShop.common.IConverter;
//
//public class OrderConverter  implements ICombiner<DbOrder>, IConverter<DbOrder, Order> {
//	@Override
//	public void combine(DbOrder original, DbOrder update) {
//		original.user = update.user;
//		original.denormalizedAddress = update.denormalizedAddress;
//		original.orderTotalPrice = update.orderTotalPrice;
//		original.ordersStatus = update.ordersStatus;
//		original.orderStatus = update.orderStatus;
//		original.updatedAt = update.updatedAt;
//	}
//
//	@Override
//	public DbOrder convertModelToDb(Order input) {
//		return input == null ? null : new DbOrder(
//					input.denormalizedAddress,
//					input.orderTotalPrice,
//					input.orderAddress,
//					input.ordersStatus,
//					input.orderStatus
//				);
//	}
//
//	@Override
//	public Order convertDbToModel(DbOrder input) {
//		return input == null ? null : new Order(
//					input.denormalizedAddress,
//					input.orderTotalPrice,
//					input.orderAddress,
//					input.ordersStatus,
//					input.orderStatus,
//					input.orderId,
//					input.user.userId
//			);
//	}
//}
