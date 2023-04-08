package shoesShop.enums;

public enum OrderStatus {
	Cancelled("Cancelled"),
	Completed("Completed"),
	Failed("Failed"),
	OnHold("OnHold"),
	PendingPayment("PendingPayment"),
	Processing("Processing"),
	Refunded("Refunded");
	
	private String description;
	
	OrderStatus(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
}
