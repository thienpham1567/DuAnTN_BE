package shoesShop.common.Size;

import java.io.Serializable;
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
import shoesShop.common.Category.DbCategory;
import shoesShop.common.ProductVariationSizes.DbProductVariationSize;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Sizes")
public class DbSize implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer sizeId;
	
	public String value;
	
	@OneToMany(mappedBy = "size")
	Collection<DbProductVariationSize> productVariationSizes = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name = "CategoryId")
	public DbCategory category;

	public DbSize(String value, Integer categoryId) {
		super();
		this.value = value;
		this.category.categoryId = categoryId;
	}
}
