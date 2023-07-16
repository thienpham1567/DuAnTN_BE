package shoesShop.common.District;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Province.DbProvince;
import shoesShop.common.Ward.DbWard;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class District {
	public Integer districtId;
	public String name;
	public String prefix;
}
