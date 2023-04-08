package shoesShop.common.Brand;

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
import shoesShop.common.Product.DbProduct;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Brands")
public class DbBrand {
	public DbBrand(String name) {
		this.name = name;
	}
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer brandId;
	
	public String name;
	
	@OneToMany(mappedBy = "brand")
	Collection<DbProduct> products = new ArrayList<>();
}
