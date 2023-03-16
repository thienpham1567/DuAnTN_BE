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
	public DbProduct(String name, String imageLink, Double price, Integer inStock,
			LocalDateTime created, Boolean isAvailable, DbBrand brand, DbCategory category) {
		super();
		this.name = name;
		this.imageLink = imageLink;
		this.price = price;
		this.inStock = inStock;
		this.created = created;
		this.isAvailable = isAvailable;
		this.brand = brand;
		this.category = category;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer productId;

	public String name;
	public String imageLink;
	public Double price;
	public Integer inStock;
	public LocalDateTime created;
	public Boolean isAvailable;

	@ManyToOne
	@JoinColumn(name = "BrandId", referencedColumnName = "BrandId")
	public DbBrand brand;

	@ManyToOne
	@JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")
	public DbCategory category;

	@OneToMany(mappedBy = "product")
	Collection<DbOrderDetail> orderDetails = new ArrayList();
}
