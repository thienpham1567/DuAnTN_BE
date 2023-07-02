package shoesShop.common.Product;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
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
import shoesShop.common.Brand.DbBrand;
import shoesShop.common.Category.DbCategory;
import shoesShop.common.ProductVariations.DbProductVariation;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Products")
public class DbProduct {
	public DbProduct(String name, Double price, String sku, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.name = name;
		this.price = price;
		this.sku = sku;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer productId;

	public String name;
	public Double price;
	public String sku;
	@Column(name = "description", columnDefinition = "LONGTEXT")
	public String description;
	public LocalDateTime createdAt;
	public LocalDateTime updatedAt;

	@ManyToOne
	@JoinColumn(name = "BrandId")
	public DbBrand brand;

	@ManyToOne
	@JoinColumn(name = "CategoryId")
	public DbCategory category;

	// ok
	@OneToMany(mappedBy = "product")
	Collection<DbProductVariation> productVariations = new ArrayList<>();
}
