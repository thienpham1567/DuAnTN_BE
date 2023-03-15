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
@Entity
@Table(name = "Products")
public class DbProduct {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
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
	
	@OneToMany(mappedBy = "orderDetail")
	Collection<DbOrderDetail> orderDetails = new ArrayList();
}
