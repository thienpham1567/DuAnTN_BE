package shoesShop.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "OrderStatus")
public class DbOrderStatus {
	public DbOrderStatus(String description, LocalDateTime created) {
		super();
		this.description = description;
		this.created = created;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer orderStatusId;
	public String description;
	public LocalDateTime created;
	
	@OneToMany(mappedBy = "orderStatus")
	Collection<DbOrder> orders = new ArrayList<>();
}
