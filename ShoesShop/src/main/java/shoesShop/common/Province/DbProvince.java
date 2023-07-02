package shoesShop.common.Province;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.District.DbDistrict;
import shoesShop.common.Ward.DbWard;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Provinces")
public class DbProvince {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer provinceId;
	
	public String name;
	public String code;
	
	// ok
	@OneToMany(mappedBy = "province")  
	Collection<DbWard> wards = new ArrayList<>();
	
	// ok
	@OneToMany(mappedBy = "province")    
	Collection<DbDistrict> districts = new ArrayList<>();
	
	// done
}
