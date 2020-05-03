package farmSim;


public abstract class FarmItem {
	
	private String name, description;
	private double salePrice, purchasePrice;
	
	public FarmItem (String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.salePrice = price / 2;
		this.purchasePrice = price;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.description;
	}
	
	public double getBuyPrice() { //Player buying from store
		return this.purchasePrice;
	}
	
	public double getSalePrice() { //Player selling to store
		return this.salePrice;
	}


}
