package shoesShop.common.Ward;

import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Address.Address;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ward {
	public Integer wardId;
	public String name;
	public String prefix;
	
	Collection<Address> address;
}
