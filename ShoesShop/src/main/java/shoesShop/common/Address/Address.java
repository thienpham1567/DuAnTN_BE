package shoesShop.common.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.District.District;
import shoesShop.common.Province.Province;
import shoesShop.common.Ward.Ward;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	public Integer addressId;
	public String address;
	public String fullName;
	public String phoneNumber;
	public String email;
	public Integer wardId;
	public Integer districtId;
	public Integer provinceId;
}
