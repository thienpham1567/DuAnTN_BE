package shoesShop.enums;

public enum ProductStatus {
	// The product is ready to sell and is available to customers 
	Active("Active"),
	// The product is no longer being sold and isn't available to customers
	Archived("Archived"),
	// The product isn't ready to sell and is unavailable to customers
	Draft("Draft");
	
	private String description;
	
	ProductStatus(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
}
