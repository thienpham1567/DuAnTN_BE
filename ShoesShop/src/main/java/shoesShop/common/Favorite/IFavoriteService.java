package shoesShop.common.Favorite;

import shoesShop.common.ProductVariations.ProductVariation;
import shoesShop.common.User.User;

public interface IFavoriteService {
	DbFavorite findByUsernameAndProductId(Integer userId, Integer productId);
	
	DbFavorite create(User user, ProductVariation productVariation);
}
