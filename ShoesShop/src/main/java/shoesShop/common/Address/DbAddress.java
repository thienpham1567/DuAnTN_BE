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
import shoesShop.common.District.DbDistrict;
import shoesShop.common.Province.DbProvince;
import shoesShop.common.User.DbUser;
import shoesShop.common.UserAddress.DbUserAddress;
import shoesShop.common.Ward.DbWard;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Addresses")
public class DbAddress {
	public DbAddress(String fullName, String phoneNumber, String email, String address) {
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer addressId;
	
	public String address;
	public String fullName;
	public String phoneNumber;
	public String email;
	
	@ManyToOne
	@JoinColumn(name = "WardId")
	public DbWard ward;
	
	@ManyToOne
	@JoinColumn(name = "DistrictId")
	public DbDistrict district;
	
	@ManyToOne
	@JoinColumn(name = "ProvinceId")
	public DbProvince province;
	
	@OneToMany(mappedBy = "address") 
	Collection<DbUserAddress> addresses = new ArrayList<>(); 
}
