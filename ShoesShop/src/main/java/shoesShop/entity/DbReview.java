package shoesShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Reivews")
public class DbReview {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer reviewId;
}
