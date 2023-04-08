package shoesShop.entity;

import java.util.Collection;

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
@Table(name = "CartItems")
public class DbCartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer cartItemId;
	
	public Double price;
	public Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "proudctItemId", referencedColumnName = "ProudctItemId")
	public DbProductItem productItem;
	
	@ManyToOne
	@JoinColumn(name = "cartId", referencedColumnName = "CartId")
	public DbCart cart;
}
