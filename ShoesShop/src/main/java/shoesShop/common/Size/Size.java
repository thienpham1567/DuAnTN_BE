package shoesShop.common.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Category.Category;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Size {
	public Integer sizeId;
	public String value;
	public String code;
	public Category category;
}
