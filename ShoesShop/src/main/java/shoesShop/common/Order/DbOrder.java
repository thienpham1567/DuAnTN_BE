package shoesShop.common.Order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Address.DbAddress;
import shoesShop.common.OrderLine.DbOrderLine;
import shoesShop.common.User.DbUser;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class DbOrder {
	public DbOrder(String orderId, DbAddress address, Double orderTotalPrice, String ordersStatus, LocalDateTime createdAt, LocalDateTime updatedAt, DbUser user ) {
		this.orderId = orderId;
		this.address = address;
		this.orderTotalPrice = orderTotalPrice;
		this.ordersStatus = ordersStatus;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.user = user;
	}

	@Id
	public String orderId;
	public Double orderTotalPrice;
	public String ordersStatus;
	public LocalDateTime createdAt;
	public LocalDateTime updatedAt;
	
	// ok
	@ManyToOne
	@JoinColumn(name = "UserId")
	public DbUser user;
	
	@ManyToOne
	@JoinColumn(name = "AddressId")
	public DbAddress address;
	 
	// ok
	@OneToMany(mappedBy = "order")
	Collection<DbOrderLine> orderLines = new ArrayList<>();

	// done
}
