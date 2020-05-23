package items;

/**
 * Class to represent Brush Item
 * Item functions in game as a daily action booster
 * @see Item
 */
public class Shampoo extends Item {
	
	private final static String SHAMP_NAME = "Shampoo";		
	private final static String SHAMP_DESC = "Bottle of animal shampoo";		
	private final static float SHAMP_PRICE = 4;			
	private final static String SHAMP_EFFECT = "mood";	
	private final static float SHAMP_MULT = 3;		
	
	/**
	 * Constructs the Brush object from public constant values defined in Brush.java.
	 * Every Brush object is a deepcopy of each other (same attribute values and structure, but different objects)
	 */
	public Shampoo() {
		super(SHAMP_NAME, SHAMP_DESC, SHAMP_PRICE, SHAMP_EFFECT, SHAMP_MULT);
	}
}
