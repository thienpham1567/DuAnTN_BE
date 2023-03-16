package shoesShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "OrderDetails")
public class DbOrderDetail {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer orderDetailId;
	
	public Double detailPrice;
	public Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
	public DbProduct product;
	
	@ManyToOne
	@JoinColumn(name = "OrderId", referencedColumnName = "OrderId")
	public DbOrder order;	
}
