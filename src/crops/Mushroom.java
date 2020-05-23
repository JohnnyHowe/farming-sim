package crops;

/**
 * Structure and attribute subclass to construct Mushroom objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 * 
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Crop
 */
public class Mushroom extends Crop {
	
	public final static String MUSH_NAME = "Mushroom";
	public final static String MUSH_DESC = "Kind of, mushy...";
	public final static float MUSH_PRICE = 4;
	public final static float MUSH_INCOME = 200;
	private final static FarmItems MUSH_ENUM = FarmItems.MUSHROOM;

    public Mushroom() {
		super(MUSH_NAME, MUSH_DESC, MUSH_PRICE, MUSH_INCOME, MUSH_ENUM);
	}
}
