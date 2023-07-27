 package shoesShop.common.Address;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.UserAddress.DbUserAddress;
import shoesShop.common.Ward.DbWard;

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
	public String ward;
	public String district;
	public String province;
	
	@OneToMany(mappedBy = "address") 
	Collection<DbUserAddress> addresses = new ArrayList<>(); 
}
