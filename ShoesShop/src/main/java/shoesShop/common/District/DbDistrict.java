package shoesShop.common.District;

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
import shoesShop.common.Cart.DbCart;
import shoesShop.common.Province.DbProvince;
import shoesShop.common.Ward.DbWard;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Districts")
public class DbDistrict {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer districtId;
	
	public String name;
	public String prefix;
	
	// ok
	@OneToMany(mappedBy = "district") 
	Collection<DbWard> wards = new ArrayList<>(); 
	
	// ok
	@ManyToOne
	@JoinColumn(name = "ProvinceId")
	public DbProvince province;
	
	// done
} 
