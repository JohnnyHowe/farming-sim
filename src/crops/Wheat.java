package crops;

/**
 * Structure and attribute subclass to construct Wheat objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 * 
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Crop
 */
public class Wheat extends Crop {
	
	private final static String WHEAT_NAME = "Wheat";
	private final static String WHEAT_DESC = "Wheaty wheat";
	private final static float WHEAT_PRICE = 2;
	private final static float WHEAT_INCOME = 100;
	private final static FarmItems WHEAT_ENUM = FarmItems.WHEAT;
	
    public Wheat() {
		super(WHEAT_NAME, WHEAT_DESC, WHEAT_PRICE, WHEAT_INCOME, WHEAT_ENUM);
	}
}