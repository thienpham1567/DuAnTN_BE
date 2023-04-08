package shoesShop.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Categories")
public class DbCategory {
	
	public DbCategory( String name) {
		super();
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer categoryId;
	
	public String name;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="parenCategoryId", referencedColumnName = "ParenCategoryId")
	private DbCategory parentCategory;
	
	@OneToMany(mappedBy = "category")
	Collection<DbProduct> products = new ArrayList<>();
}
