package shoesShop.common.Review;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.RecordManager;
import shoesShop.common.ProductVariations.IProductVariationRepository;
import shoesShop.common.User.IUserRepository;

@Service
public class ReviewService extends RecordManager<Review> {
	@Autowired
	private IReviewRepository reviewRepo;
	
	@Autowired
	private IUserRepository userRepo;
	
	@Autowired
	private IProductVariationRepository productVariationRepo;
	
	ReviewConverter converter = new ReviewConverter();
	
	@Override
	public Collection<Review> retrieveAll() {
		Collection<Review> reviews = this.load(null)
				.stream().map(dbReivew -> this.converter.convertDbToModel(dbReivew))
				.collect(Collectors.toList());
		return reviews;
	}
	
	@Override
	public Review create(Review review) throws Exception {
		DbReview dbReview = this.converter.convertModelToDb(review);
		System.out.println("User id: " + this.userRepo.findById(review.userId).get());
		dbReview.user = this.userRepo.findById(review.userId).get();
		dbReview.productVariation = this.productVariationRepo.findById(review.productVariationId).get();
		DbReview createdReview = this.reviewRepo.save(dbReview);
		return this.converter.convertDbToModel(createdReview);
	}
	
	private Collection<DbReview> load(Integer reviewId){
		Collection<DbReview> dbReviews = this.reviewRepo.findAll();
		if(reviewId != null)
			dbReviews = dbReviews.stream().filter(dbReview -> dbReview.reviewId == reviewId).collect(Collectors.toList());
		return dbReviews;
	}
}
