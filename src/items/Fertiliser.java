package items;

/**
 * Class to represent Bonemeal Item.
 * Item functions in game as a daily action booster.
 * @see Item
 */
public class Fertiliser extends Item {
	
	private final static String FERT_NAME = "Fertilizer";		//Display Name
	private final static String FERT_DESC = "Bag full of fertilizer";		//Description
	private final static float FERT_PRICE = 4;				//Base Price
	private final static String FERT_EFFECT = "growth";		//Item Effect
	private final static float FERT_MULT = 3;
	private final static FarmItems FERT_ENUM = FarmItems.FERTILISER;
	
	/**
	 * Constructs the Bonemeal object from public constant values defined in Bonemeal.java.
	 * Every Bonemeal object is a deepcopy of each other (same attribute values and structure, but different objects)
	 */
	public Fertiliser() {
		super(FERT_NAME, FERT_DESC, FERT_PRICE, FERT_EFFECT, FERT_MULT, FERT_ENUM);
	}
}
