package items;

/**
 * Structure and attribute subclass to construct Shampoo objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 * 
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Item
 */
public class Shampoo extends Item {
	
	private final static String SHAMP_NAME = "Shampoo";		
	private final static String SHAMP_DESC = "Bottle of animal shampoo";		
	private final static float SHAMP_PRICE = 4;			
	private final static String SHAMP_EFFECT = "mood";	
	private final static float SHAMP_MULT = 3;	
	private final static FarmItems SHAMP_ENUM = FarmItems.SHAMPOO;
	
	public Shampoo() {
		super(SHAMP_NAME, SHAMP_DESC, SHAMP_PRICE, SHAMP_EFFECT, SHAMP_MULT, SHAMP_ENUM);
	}
}
