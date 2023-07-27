package shoesShop.common.District;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {
	public Integer districtId;
	public String name;
	public String prefix;
	
	public Integer provinceId;
}
