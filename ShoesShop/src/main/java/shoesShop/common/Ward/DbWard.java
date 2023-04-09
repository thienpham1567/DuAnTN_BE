package shoesShop.common.Ward;

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
import shoesShop.common.Province.DbProvince;
import shoesShop.common.District.DbDistrict;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Wards")
public class DbWard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer wardId;
	
	@ManyToOne
	@JoinColumn(name = "ProvinceId")
	public DbProvince province;
	
	@ManyToOne
	@JoinColumn(name = "DistrictId")
	public DbDistrict district;
}
