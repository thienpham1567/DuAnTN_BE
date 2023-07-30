package shoesShop.common.Review;

import shoesShop.common.IConverter;
import shoesShop.common.User.UserConverter;

public class ReviewConverter implements IConverter<DbReview, Review>{
	private UserConverter userConverter = new UserConverter();
	@Override
	public DbReview convertModelToDb(Review input) {
		return input == null ? null : new DbReview(
					input.productVariationId,
					input.content,
					input.rateStar,
					input.createdAt
				);
	}

	@Override
	public Review convertDbToModel(DbReview input) {
		return input == null ? null : new Review(
					input.reviewId,
					this.userConverter.convertDbToModel(input.user),
					input.productVariation.productVariationId,
					input.content,
					input.rateStar,
					input.createdAt
				);
	}

}
