package shoesShop.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class DbSize {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer sizeId;
}
