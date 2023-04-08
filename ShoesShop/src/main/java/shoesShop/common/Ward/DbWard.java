package shoesShop.common.Ward;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DbWard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer wardId;
}
