package farmSim;


public abstract class FarmItem {
	
	private String name;
	private String description;

	private float sellPrice;
	private float purchasePrice;

	/**
	 * 
	 * @param name FarmItem name, used when viewing status of item
	 * @param description FarmItem description, used when viewing status of item
	 * @param price FarmItem price, used when buying or selling to store
	 */
	public FarmItem (String name, String description, float price) {
		this.name = name;
		this.description = description;
		this.sellPrice = price / 2;
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
     * How much does the player pay when BUYING the item?
	 * @return price
	 */
	public float getBuyPrice() { //Player buying from store
		return this.purchasePrice;
	}

	/**
     * How much does the player receive when SELLING the item?
	 * @return sale price
	 */
	public float getSellPrice() { //Player selling to store
		return this.sellPrice;
	}

	protected abstract void endDay();


}
