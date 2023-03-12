package shoesShop.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	
	public String name;
	public String imageLink;
	public double price;
	public int inStock;
	public LocalDateTime created;
	public boolean isAvailable;
	
	@ManyToOne
	@JoinColumn(name = "BrandId", referencedColumnName = "BrandId")
	public Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")
	public Category category;
	
	@OneToMany(mappedBy = "orderDetail")
	List<OrderDetail> orderDetails = new ArrayList();
}
