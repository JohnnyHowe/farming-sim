package items;

/**
 * Class to represent Bonemeal Item.
 * Item functions in game as a daily action booster.
 * @see Item
 */
public class Bonemeal extends Item {
	
	private final static String BONE_NAME = "Bonemeal";		//Display Name
	private final static String BONE_DESC = "Spooky";		//Description
	private final static float BONE_PRICE = 2;				//Base Price
	private final static String BONE_EFFECT = "growth";		//Item Effect
	private final static float BONE_MULT = 2;
	
	/**
	 * Constructs the Bonemeal object from public constant values defined in Bonemeal.java.
	 * Every Bonemeal object is a deepcopy of each other (same attribute values and structure, but different objects)
	 */
	public Bonemeal() {
		super(BONE_NAME, BONE_DESC, BONE_PRICE, BONE_EFFECT, BONE_MULT);
	}
}
