package shoesShop.common.Category;

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

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Product.DbProduct;
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
