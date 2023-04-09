package shoesShop.common.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Size {
	public Integer sizeId;
	public String value;
	public Integer categoryId;
}
