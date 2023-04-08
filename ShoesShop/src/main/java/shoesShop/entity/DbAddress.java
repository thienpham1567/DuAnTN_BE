package shoesShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table(name = "Addresses")
public class DbAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer addressId;
	
	public String address;
	public String ward;
}
