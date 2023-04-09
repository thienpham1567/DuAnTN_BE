package shoesShop.common.ProductItem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import shoesShop.common.Color.DbColor;
import shoesShop.common.Product.DbProduct;
import shoesShop.common.Size.DbSize;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ProductItems")
public class DbProductItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer productItemId;
	
	public String sku;
	public Double price;
	public Integer quantityInStock;
	public String imageUrl;
	public String status;
	
	@ManyToOne
	@JoinColumn(name = "sizeId", referencedColumnName = "SizeId")
	public DbSize size;
	
	@ManyToOne
	@JoinColumn(name = "colorId", referencedColumnName = "ColorId")
	public DbColor color;
	
	@ManyToOne
	@JoinColumn(name = "productId", referencedColumnName = "ProductId")
	public DbProduct product;
}
