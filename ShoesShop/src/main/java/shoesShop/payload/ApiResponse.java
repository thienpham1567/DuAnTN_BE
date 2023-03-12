package shoesShop.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
	private String status;
	private T data;
	private String errorMessage;
}
