package shoesShop.entity;

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
@Table(name = "Provinces")
public class DbProvince {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer provinceId;
	
	public String name;
	public String code;
}
