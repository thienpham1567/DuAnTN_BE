package shoesShop.common.Favorite;

import java.time.LocalDateTime;
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
import shoesShop.common.ProductVariations.DbProductVariation;
import shoesShop.common.User.DbUser;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Favorites")
public class DbFavorite {
	
	public DbFavorite(Integer favoriteId) {
		this.favoriteId = favoriteId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
		
	public Integer favoriteId;
	@ManyToOne
	@JoinColumn(name = "UserId")
	public DbUser user;
	
	@ManyToOne
	@JoinColumn(name = "ProductVariationId")
	public DbProductVariation productVariation;
	
	
	public LocalDateTime vieweddate;
	
	public Boolean isliked;

	public LocalDateTime likedDate;


}
