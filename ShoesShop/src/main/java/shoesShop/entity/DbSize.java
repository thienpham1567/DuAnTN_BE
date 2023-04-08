package shoesShop.entity;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Sizes")
public class DbSize {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer sizeId;
	
	public String value;
	
	@ManyToOne
	@JoinColumn(name = "categoryId", referencedColumnName = "CategoryId")
	public DbCategory category;
}
