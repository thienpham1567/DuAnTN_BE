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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Orders")
public class DbOrder {
	@Id
	public String orderId;
	
	public LocalDateTime created;
	public LocalDateTime updated;
	public Double orderAmount;
	
	@ManyToOne
	@JoinColumn(name = "UserId", referencedColumnName = "UserId")
	public DbUser user;
	
	@OneToMany(mappedBy = "order")
	Collection<DbOrderLine> orderDetails = new ArrayList<>();
	
	@OneToOne
	@JoinColumn(name = "OrderAddress", referencedColumnName = "OrderAddressId")
	DbAddress orderAddress;
}
