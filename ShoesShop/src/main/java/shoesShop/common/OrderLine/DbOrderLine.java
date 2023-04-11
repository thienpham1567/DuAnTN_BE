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
import shoesShop.common.Order.DbOrder;
import shoesShop.common.ProductItem.DbProductItem;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderLines")
public class DbOrderLine {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer orderLineId;
	
	public Double price;
	public Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "ProductItemId")
	public DbProductItem productItem;
	
	@ManyToOne
	@JoinColumn(name = "OrderId")
	public DbOrder order;	
}
