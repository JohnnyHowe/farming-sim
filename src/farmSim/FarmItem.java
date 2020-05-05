package farmSim;


public abstract class FarmItem {
	
	private String name;
	private String description;

	private double salePrice;
	private double purchasePrice;

	public FarmItem (String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.salePrice = price / 2;
		this.purchasePrice = price;
	}

	/**
	 * Get the name of the item
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Get the description of the item
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Get the full price of the item
	 * @return price
	 */
	public double getBuyPrice() { //Player buying from store
		return this.purchasePrice;
	}

	/**
	 * Get the sale price of the item
	 * @return sale price
	 */
	public double getSalePrice() { //Player selling to store
		return this.salePrice;
	}


}
