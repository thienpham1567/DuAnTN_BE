package shoesShop.common.ProductDetails;

import java.time.LocalDateTime;

public interface ProductDTO {
	Integer getProduct_id();
    LocalDateTime getCreated_at();
    String getDescription();
    String getName();
    Double getPrice();
    String getSku();
    LocalDateTime getUpdated_at();
    Integer getBrand_id();
    Integer getCategory_id();
    Integer getColor_id();
    Integer getProduct_imageld();
    Integer getQuantity();
    String getImage_url();
    Integer getSize_id();
    Boolean getIs_primary();
    String getValue();
}
