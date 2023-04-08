package shoesShop.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Colors")
public class DbColor {
	public Integer colorId;
}
