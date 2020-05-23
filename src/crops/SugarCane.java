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
	
	public final static String CANE_NAME = "Sugar Cane";
	public final static String CANE_DESC = "Sugary cane";
	public final static float CANE_PRICE = 3;
	public final static float CANE_INCOME = 150;
	private final static FarmItems CANE_ENUM = FarmItems.SUGAR_CANE;

    public SugarCane() {
		super(CANE_NAME, CANE_DESC, CANE_PRICE, CANE_INCOME, CANE_ENUM);
	}
}