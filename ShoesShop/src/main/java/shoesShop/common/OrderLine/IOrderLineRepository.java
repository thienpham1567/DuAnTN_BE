package shoesShop.common.OrderLine;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import shoesShop.common.Product.DbProduct;

@Repository
public interface IOrderLineRepository extends JpaRepository<DbOrderLine, Integer> {
	// Thống kê nhãn hiệu bán chạy
	@Query(value = "select count(b.name), b.name from order_lines ol inner join product_variation_sizes pvs on ol.product_variation_size_id = pvs.product_variation_size_id "
			+ "inner join product_variations pv on pvs.product_variation_id = pv.product_variation_id "
			+ "inner join products p on p.product_id = pv.product_id "
			+ "inner join brands b on b.brand_id = p.brand_id "
			+ "group by (name)", nativeQuery = true)
	List<Object[]> getReportByBrands();
}
