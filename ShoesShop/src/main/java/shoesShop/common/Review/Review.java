package shoesShop.common.Review;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	public Integer reviewId;
	public Integer userId;
	public Integer productVariationId;
	public String content;
	public Integer rateStar;
	public LocalDateTime createdAt;
}
