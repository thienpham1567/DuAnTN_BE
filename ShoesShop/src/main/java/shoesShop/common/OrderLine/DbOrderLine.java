package shoesShop.common.OrderLine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Color.DbColor;
import shoesShop.common.Order.DbOrder;
import shoesShop.common.Order.Order;
import shoesShop.common.ProductVariationSizes.DbProductVariationSize;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderLines")
public class DbOrderLine {
	public DbOrderLine(String orderId, Double price, Integer quantity,DbProductVariationSize productVariationSize, String imageUrl, DbColor color) {
	    this.order = new DbOrder(); // Khởi tạo đối tượng order
	    this.order.orderId = orderId;
	    this.price = price;
	    this.quantity = quantity;
	    this.productVariationSize = productVariationSize;
	    this.imageUrl = imageUrl;
	    this.color = color;	
	}

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer orderLineId;
	
	public Double price;
	public Integer quantity;
	public String imageUrl;
	// ok
	@ManyToOne
	@JoinColumn(name = "OrderId")
	public DbOrder order;
	
	// ok
	@ManyToOne
	@JoinColumn(name = "ProductVariationSizeId")
	public DbProductVariationSize productVariationSize;
	
	@ManyToOne
	@JoinColumn(name = "ColorId")
	public DbColor color;
	// done
}
