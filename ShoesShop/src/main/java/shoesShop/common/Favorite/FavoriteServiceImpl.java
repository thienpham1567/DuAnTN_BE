package shoesShop.common.Favorite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shoesShop.common.ProductVariations.IProductVariationRepository;
import shoesShop.common.ProductVariations.ProductVariation;
import shoesShop.common.User.IUserRepository;
import shoesShop.common.User.User;
@Service

public class FavoriteServiceImpl implements IFavoriteService{
	@Autowired
	IFavoriteRepository repo;
	
	@Autowired
	IUserRepository userRepo;
	
	@Autowired
	IProductVariationRepository productVariationRepo;
	
	@Override
	public DbFavorite findByUsernameAndProductId(Integer userId, Integer productId) {
		return repo.findByUsernameAndProductId(userId, productId);
	}

	@Override
	public DbFavorite create(User user, ProductVariation productVariation) {
		System.out.println("Hello");
		DbFavorite existFavourite = findByUsernameAndProductId(user.userId, productVariation.productVariationId);
		if(existFavourite == null) {
			existFavourite = new DbFavorite();
			existFavourite.setUser(this.userRepo.findById(user.getUserId()).get());
			existFavourite.setProductVariation(this.productVariationRepo.findById(productVariation.getProductVariationId()).get());
			existFavourite.setIsliked(false);
			return repo.save(existFavourite);
		}
		return existFavourite;
	}

}
