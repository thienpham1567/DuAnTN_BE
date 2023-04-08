package shoesShop.entity;

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
	@JoinColumn(name = "ProductId", referencedColumnName = "ProductId")
	public DbProduct product;
	
	@ManyToOne
	@JoinColumn(name = "OrderId", referencedColumnName = "OrderId")
	public DbOrder order;	
}
