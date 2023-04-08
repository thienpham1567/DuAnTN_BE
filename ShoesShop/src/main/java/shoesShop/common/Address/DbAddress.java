 package shoesShop.common.Address;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Addresses")
public class DbAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer addressId;
	
	public String address;
	public Integer wardId;
}
