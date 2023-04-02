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
@Table(name = "OrderAddresses")
public class DbOrderAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer orderAddressId;
	
	public String address;
	public String ward;
	public String district;
	public String phoneNumber;
}
