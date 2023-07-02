package shoesShop.common.Review;

import shoesShop.common.IConverter;

public class ReviewConverter implements IConverter<DbReview, Review>{

	@Override
	public DbReview convertModelToDb(Review input) {
		return input == null ? null : new DbReview(
					input.userId,
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
					input.user.userId,
					input.productVariation.productVariationId,
					input.content,
					input.rateStar,
					input.createdAt
				);
	}

}
