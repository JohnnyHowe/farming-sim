package farm;

/**
 * General superclass for all game objects excluding farm, farmer, factory etc.
 * @author Alex Burling(arb142), Jonathon Howe(joh29)
 * @see Animal
 * @see Crop
 * @see Item
 */
public abstract class FarmItem {
	
	private String name;
	private String description;

	private float sellPrice;
	private float purchasePrice;
	private FarmItems selfEnum;
	
	public static enum FarmItems {COW, SHEEP, CHICKEN, CACTUS, MELON, MUSHROOM, PUMPKIN, SUGAR_CANE, WHEAT,
		GRAIN, FEED_BAG, BONEMEAL, FERTILISER, BRUSH, SHAMPOO};

	/**
	 * 
	 * @param name FarmItem name, used when viewing status of item
 * @param description FarmItem description, used when viewing status of item
	 * @param price FarmItem price, used when buying or selling to store
	 */
	public FarmItem (String name, String description, float price, FarmItems selfEnum) {
		this.name = name;
		this.description = description;
		this.sellPrice = price / 2;
		this.purchasePrice = price;
		this.selfEnum = selfEnum;
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

	/**
	 * Abstract method definition to simplify endDay gameloop in action handler.
	 * Rather than dealing with each FarmItem subclass individually, each subclass
	 * implements it's own endDay() with the correct outcome.
	 */
	public abstract void endDay();

	public FarmItems getEnum() {
		return selfEnum;
	}


}
