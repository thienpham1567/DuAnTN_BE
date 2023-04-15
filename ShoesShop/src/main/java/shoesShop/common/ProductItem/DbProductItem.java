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
	
	public DbProductItem(Integer colorId, String imageUrl, Double price, Integer quantityInStock, String sku,
			Integer productItemId, String status, Integer sizeId,Integer productId) {
		this.color.colorId = color.colorId;
		this.imageUrl = imageUrl;
		this.price = price;
		this.quantityInStock = quantityInStock;
		this.sku = sku;
		this.productItemId = productItemId;
		this.status = status;
		this.size.sizeId = size.sizeId;
		this.product.productId = product.productId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer productItemId;
	
	public String sku;
	public Double price;
	public Integer quantityInStock;
	public String imageUrl;
	public String status;
	
	@ManyToOne
	@JoinColumn(name = "SizeId")
	public DbSize size;
	
	@ManyToOne
	@JoinColumn(name = "ColorId")
	public DbColor color;
	
	@ManyToOne
	@JoinColumn(name = "ProductId")
	public DbProduct product;
}
