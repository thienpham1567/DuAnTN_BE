package shoesShop.common.Product;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import shoesShop.common.ProductDetails.ProductDTO;

public interface IProductRepository extends JpaRepository<DbProduct, Integer> {
	@Query(value = "select * from Products s where s.Name like %:keyword%", nativeQuery = true)
	Collection<DbProduct> findByKeyword(@Param("keyword") String keyword);
	
	/*--Filter: get all products by brand id--*/
	@Query(value = "select * from products p inner join brands b on p.brand_id = b.brand_id where b.brand_id = ?1;", nativeQuery = true)
	Collection<DbProduct> findAllProductsByBrandId(@Param("id") Integer id);
	
	/*--Filter: get all products by category id--*/
	@Query(value = "select * from products p inner join categories c on p.category_id = c.category_id where c.category_id = ?1;", nativeQuery = true)
	Collection<DbProduct> findAllProductsByCategoryId(@Param("id") Integer id);
	
	/*--Search product by product name--*/
	@Query(value = "SELECT distinct p from DbProduct p WHERE p.name like %?1%")
	Collection<DbProduct> searchProductsByName(String name);
	
	/*--
	 * Get product details
	 * 		1 sản phẩm
	 * 			3 màu => 1 màu 5 tấm hình - nhiều size
	 * 
	 * --*/
	@Query(value = "select p.product_id, p.created_at, p.description, p.name, p.price, p.sku, p.updated_at, p.brand_id, p.category_id, pv.color_id, "
			+ "pi.product_imageld, pvs.quantity, pi.image_url, pvs.size_id, pi.is_primary, s.value "
			+ "from products p "
			+ "inner join product_variations pv on p.product_id = pv.product_id "
			+ "inner join product_images pi on pv.product_variation_id = pi.product_variation_id "
			+ "inner join colors col on col.color_id = pv.color_id "
			+ "inner join product_variation_sizes pvs on pvs.product_variation_id = pv.product_variation_id "
			+ "inner join sizes s on s.size_id = pvs.size_id where p.product_id = ?1", nativeQuery = true)
	Collection<ProductDTO> getProductDetails(Integer id);
	
	/*--Get all product--*/
	@Query(value = "select p.product_id, p.created_at, p.description, p.name, p.price, p.sku, p.updated_at, p.brand_id, p.category_id, pv.color_id, "
			+ "pi.product_imageld, pvs.quantity, pi.image_url, pvs.size_id, pi.is_primary, s.value "
			+ "from products p "
			+ "inner join product_variations pv on p.product_id = pv.product_id "
			+ "inner join product_images pi on pv.product_variation_id = pi.product_variation_id "
			+ "inner join colors col on col.color_id = pv.color_id "
			+ "inner join product_variation_sizes pvs on pvs.product_variation_id = pv.product_variation_id "
			+ "inner join sizes s on s.size_id = pvs.size_id", nativeQuery = true)
	Collection<ProductDTO> getAll();
}
