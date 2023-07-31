package shoesShop.common.OrderLine;

//import java.util.Collection;
//import java.util.stream.Collectors;

import shoesShop.common.ICombiner;
import shoesShop.common.IConverter;
import shoesShop.common.Color.ColorConverter;
//import shoesShop.common.ProductVariationSizes.ProductVariationSize;
import shoesShop.common.ProductVariationSizes.ProductVariationSizeConverter;

public class OrderLineConverter implements ICombiner<DbOrderLine>, IConverter<DbOrderLine, OrderLine>{
	//private OrderConverter orderConverter = new OrderConverter();
//	private CartConverter cartConverter = new CartConverter();
	//private ProductVariationSizeConverter productVariationSizeConverter = new ProductVariationSizeConverter();
	private ProductVariationSizeConverter pvsConverter = new ProductVariationSizeConverter();
	private ColorConverter colorConverter = new ColorConverter();
	
	@Override
	public void combine(DbOrderLine original, DbOrderLine update) {
		original.price = update.price;
		original.quantity = update.quantity;
		original.imageUrl = update.imageUrl;
	}

	@Override
	public DbOrderLine convertModelToDb(OrderLine input) {
		return input == null ? null : new DbOrderLine(input.price, input.quantity, input.imageUrl);
	}

	@Override
	public OrderLine convertDbToModel(DbOrderLine input) {

		return input == null ? null : new OrderLine(
				input.orderLineId,	
				input.order.orderId,
				input.price,
				input.quantity,
				input.imageUrl,
				this.pvsConverter.convertDbToModel(input.productVariationSize),
				this.colorConverter.convertDbToModel(input.color)
				);
	}


}
