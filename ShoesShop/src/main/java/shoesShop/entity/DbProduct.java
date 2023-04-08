package shoesShop.entity;

import java.time.LocalDateTime;
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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class DbProduct {
	public DbProduct(String name, String description, LocalDateTime updateAt) {
		super();
		this.name = name;
		this.description = description;
		this.updateAt = updateAt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer productId;

	public String name;
	public String description;
	public LocalDateTime createdAt;
	public LocalDateTime updateAt;

	@ManyToOne
	@JoinColumn(name = "brandId", referencedColumnName = "BrandId")
	public DbBrand brand;

	@ManyToOne
	@JoinColumn(name = "categoryId", referencedColumnName = "CategoryId")
	public DbCategory category;

	@OneToMany(mappedBy = "product")
	Collection<DbProductItem> productItems = new ArrayList<>();
}
