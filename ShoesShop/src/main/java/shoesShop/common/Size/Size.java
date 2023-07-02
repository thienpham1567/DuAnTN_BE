package shoesShop.common.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Size {
	public Size(String value, Integer categoryId) {
		this.value = value;
		this.categoryId = categoryId;
	}
	public Integer sizeId;
	public String value;
	public Integer categoryId;
}
