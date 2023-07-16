package shoesShop.common.Province;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.District.District;
import shoesShop.common.Ward.Ward;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Province {
	public Integer provinceId;
	public String name;
	public String code;
	
	public Collection<Ward> wards;
	
	public Collection<District> districts;
}
