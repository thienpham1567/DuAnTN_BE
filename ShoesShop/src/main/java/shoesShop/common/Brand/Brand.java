package shoesShop.common.Brand;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Brand implements Serializable{
	// Ids
	public Integer brandId;
	
	// Properties
	@NotEmpty
	public String name;
}
