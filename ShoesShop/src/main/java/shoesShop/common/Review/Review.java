package shoesShop.common.Review;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.User.User;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	public Integer reviewId;
	public User user;
	public Integer productVariationId;
	public String content;
	public Integer rateStar;
	public LocalDateTime createdAt;
}
