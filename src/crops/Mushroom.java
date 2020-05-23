package crops;

/**
 * Class to represent Mushroom
 * @author Alex Burling(arb142)
 * @see Crop
 */
public class Mushroom extends Crop {
	
	public final static String MUSH_NAME = "Mushroom";
	public final static String MUSH_DESC = "Kind of, mushy...";
	public final static float MUSH_PRICE = 4;
	public final static float MUSH_INCOME = 200;
	private final static FarmItems MUSH_ENUM = FarmItems.MUSHROOM;
	
	/**
	 * Constructs the Mushroom object from public constant values defined in Mushroom.java
	 * Every Mushroom object is a deepcopy of each other (same attribute values and structure, but different objects)
	 */
    public Mushroom() {
		super(MUSH_NAME, MUSH_DESC, MUSH_PRICE, MUSH_INCOME, MUSH_ENUM);
	}
}
