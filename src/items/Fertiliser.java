package items;

/**
 * Structure and attribute subclass to construct Fertiliser objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 * 
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Item
 */
public class Fertiliser extends Item {
	
	private final static String FERT_NAME = "Fertilizer";
	private final static String FERT_DESC = "Bag full of fertilizer";
	private final static float FERT_PRICE = 4;
	private final static String FERT_EFFECT = "growth";
	private final static float FERT_MULT = 3;
	private final static FarmItems FERT_ENUM = FarmItems.FERTILISER;
	
	public Fertiliser() {
		super(FERT_NAME, FERT_DESC, FERT_PRICE, FERT_EFFECT, FERT_MULT, FERT_ENUM);
	}
}
