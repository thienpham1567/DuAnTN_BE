package shoesShop.entity;

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
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Orders")
public class DbOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer orderId;
	
	public LocalDateTime created;
	public LocalDateTime updated;
	public String orderAddress;
	public Double orderAmount;
	
	@ManyToOne
	@JoinColumn(name = "UserId", referencedColumnName = "UserId")
	public DbUser user;
	
	@ManyToOne
	@JoinColumn(name = "OrderStatusId", referencedColumnName = "OrderStatusId")
	public DbOrderStatus orderStatus;
	
	@OneToMany(mappedBy = "order")
	Collection<DbOrderDetail> orderDetails = new ArrayList();
}
