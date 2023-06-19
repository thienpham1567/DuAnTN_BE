package shoesShop.common.Category;

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
import shoesShop.common.Size.DbSize;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Categories")
public class DbCategory {

	public DbCategory(String name) {
		this.name = name;
	}
	public DbCategory(String name, String code) {
		this.name = name;
		this.code = code;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer categoryId;

	public String name;
	
	public String code;
	
	
	@ManyToOne
	@JoinColumn(name = "ParentCategoryId")
	public DbCategory parentCategory;

	// ok
	@OneToMany(mappedBy = "category")
	Collection<DbSize> sizes = new ArrayList<>();
}
