package shoesShop.common.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
	public Integer addressId;
	public String address;
	public String ward;
	public String district;
	public String province;
}
