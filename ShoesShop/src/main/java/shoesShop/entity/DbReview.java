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
@Table(name = "Reivews")
public class DbReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer reviewId;
	
	public Integer rateValue;
	public String comment;
	
	@ManyToOne
	@JoinColumn(name = "orderLineId", referencedColumnName = "OrderedProductId")
	public DbOrderLine orderedProduct;
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "UserId")
	public DbUser user;
}
