package shoesShop.common.Ward;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ward {
	public String name;
	public String prefix;
	public Integer wardId;
	public Integer districtId;
	public Integer provinceId;
}
