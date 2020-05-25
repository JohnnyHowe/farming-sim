package crops;

/**
 * Structure and attribute subclass to construct SugarCane objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 * 
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Crop
 */
public class SugarCane extends Crop {
	
	private final static String CANE_NAME = "Sugar Cane";
	private final static String CANE_DESC = "Sugary cane";
	private final static float CANE_PRICE = 3;
	private final static float CANE_INCOME = 150;
	private final static FarmItems CANE_ENUM = FarmItems.SUGAR_CANE;
	private final static int GROW_TIME = 3;

    public SugarCane() {
		super(CANE_NAME, CANE_DESC, CANE_PRICE, CANE_INCOME, CANE_ENUM, GROW_TIME);
	}
}