package shoesShop.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "UserAddresses")
public class DbUserAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer userAddressId;
	
	public Boolean isDefault;
	
	@ManyToOne
	@JoinColumn(name = "addressId", referencedColumnName = "AddressId")
	public DbAddress address;
	
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "UserId")
	public DbUser user;
}
