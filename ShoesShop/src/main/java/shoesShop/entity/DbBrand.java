package shoesShop.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Brands")
public class DbBrand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer brandId;
	
	public String name;
	
	@OneToMany(mappedBy = "brand")
	Collection<DbProduct> products = new ArrayList<>();
}
