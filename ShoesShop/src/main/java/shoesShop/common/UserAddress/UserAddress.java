package shoesShop.common.UserAddress;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress {
	public boolean isDefault;
	public Integer userAddressId;
	public Integer address;
	public Integer userId;
}
