package shoesShop.common.UserAddress;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {
	public Integer userAddressId;
	public boolean isDefault;
	public Integer addressId;
	public Integer userId;
}
