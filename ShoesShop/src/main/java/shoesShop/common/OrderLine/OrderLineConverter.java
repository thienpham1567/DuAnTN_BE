package shoesShop.common.OrderLine;

//import java.util.Collection;
//import java.util.stream.Collectors;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
//import shoesShop.common.Cart.CartConverter;
import shoesShop.common.Order.OrderConverter;
//import shoesShop.common.ProductVariationSizes.ProductVariationSize;
import shoesShop.common.ProductVariationSizes.ProductVariationSizeConverter;

public class OrderLineConverter implements ICombiner<DbOrderLine>, IConverter<DbOrderLine, OrderLine>{
	//private OrderConverter orderConverter = new OrderConverter();
//	private CartConverter cartConverter = new CartConverter();
	//private ProductVariationSizeConverter productVariationSizeConverter = new ProductVariationSizeConverter();
	
	
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
					input.orderLineId
					//this.orderConverter.convertDbToModel(input.order),
					//this.productVariationSizeConverter.convertDbToModel(input.productVariationSize)
				);
	}


}
