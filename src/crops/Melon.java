package crops;

/**
 * Structure and attribute subclass to construct Melon objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 * 
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Crop
 */
public class Melon extends Crop {
	
	public final static String MELON_NAME = "Melon";
	public final static String MELON_DESC = "Watermelone";
	public final static float MELON_PRICE = 6;
	public final static float MELON_INCOME = 300;
	private final static FarmItems MELON_ENUM = FarmItems.MELON;
	
    public Melon() {
		super(MELON_NAME, MELON_DESC, MELON_PRICE, MELON_INCOME, MELON_ENUM);
	}
}
