package shoesShop.common.District;

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
import shoesShop.common.Cart.DbCart;

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
	
	@ManyToOne
	@JoinColumn(name = "provinceId", referencedColumnName = "ProvinceId")
	public DbCart province;
} 
