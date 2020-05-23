package crops;

/**
 * Class to represent Sugar cane
 * @author Alex Burling(arb142)
 * @see Crop
 */
public class SugarCane extends Crop {
	
	public final static String CANE_NAME = "Sugar Cane";
	public final static String CANE_DESC = "Sugary cane";
	public final static float CANE_PRICE = 3;
	public final static float CANE_INCOME = 150;
	private final static FarmItems CANE_ENUM = FarmItems.SUGAR_CANE;
	
	/**
	 * Constructs the Sugar cane object from public constant values defined in Sugar cane.java
	 * Every Sugar cane object is a deepcopy of each other (same attribute values and structure, but different objects)
	 */
    public SugarCane() {
		super(CANE_NAME, CANE_DESC, CANE_PRICE, CANE_INCOME, CANE_ENUM);
	}
}