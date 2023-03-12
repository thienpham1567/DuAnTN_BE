package shoesShop.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Products")
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	private String name;
	private String imageLink;
	private double price;
	private int inStock;
	private LocalDateTime created;
	private boolean isAvailable;
	
	@ManyToOne
	@JoinColumn(name = "BrandId", referencedColumnName = "BrandId")
	Brand brand;
	
	@ManyToOne
	@JoinColumn(name = "CategoryId", referencedColumnName = "CategoryId")
	Category category;
}
