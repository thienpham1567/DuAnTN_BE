package shoesShop.common.Review;

import java.io.Serializable;
import java.time.LocalDateTime;

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

import shoesShop.common.ProductVariations.DbProductVariation;
import shoesShop.common.User.DbUser;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Reviews")
public class DbReview implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer reviewId;
	
	@ManyToOne
	@JoinColumn(name = "UserId")
	public DbUser user;
	
	@ManyToOne
	@JoinColumn(name = "ProductVariationId")
	public DbProductVariation productVariation;
	
	public String content;
	
	public Integer rateStar;
	
	public LocalDateTime createdAt;

	

	public DbReview(Integer userId, Integer productVariationId, String content, Integer rateStar,
			LocalDateTime createdAt) {
		this.content = content;
		this.rateStar = rateStar;
		this.createdAt = createdAt;
	}
	
	
	
//	@ManyToOne
//	@JoinColumn(name = "OrderLineId")
//	public DbOrderLine orderedProduct;
	
	

}
