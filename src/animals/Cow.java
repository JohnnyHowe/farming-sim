package animals;

/**
 * Structure and attribute subclass to construct Cow objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 *  
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Animal
 */
public class Cow extends Animal {
	
	private final static String COW_NAME = "Cow";
	private final static String COW_DESC = "MOO";
	private final static float COW_PRICE = 2;
	private final static float COW_DAILY_PROF = 100;
	private final static float COW_BASE_HEALTH = 5;
	private final static float COW_BASE_MOOD = 5;
	private final static FarmItems COW_ENUM = FarmItems.COW;
	
	public Cow() {
		super(COW_NAME, COW_DESC, COW_PRICE, COW_DAILY_PROF, COW_BASE_HEALTH, COW_BASE_MOOD, COW_ENUM);
	}
}
