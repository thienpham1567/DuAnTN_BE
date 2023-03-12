package shoesShop.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	
	public LocalDateTime created;
	public LocalDateTime updated;
	public String orderAddress;
	public double orderAmount;
	
	@ManyToOne
	@JoinColumn(name = "UserId", referencedColumnName = "UserId")
	public User user;
	
	@ManyToOne
	@JoinColumn(name = "OrderStatusId", referencedColumnName = "OrderStatusId")
	public OrderStatus orderStatus;
	
	@OneToMany(mappedBy = "orderDetail")
	List<OrderDetail> orderDetails = new ArrayList();
}
