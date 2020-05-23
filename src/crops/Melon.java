package crops;

/**
 * Class to represent Melon
 * @author Alex Burling(arb142)
 * @see Crop
 */
public class Melon extends Crop {
	
	public final static String MELON_NAME = "Melon";
	public final static String MELON_DESC = "Watermelone";
	public final static float MELON_PRICE = 6;
	public final static float MELON_INCOME = 300;
	private final static FarmItems MELON_ENUM = FarmItems.MELON;
	
	/**
	 * Constructs the Melon object from public constant values defined in Melon.java
	 * Every Melon object is a deepcopy of each other (same attribute values and structure, but different objects)
	 */
    public Melon() {
		super(MELON_NAME, MELON_DESC, MELON_PRICE, MELON_INCOME, MELON_ENUM);
	}
}
