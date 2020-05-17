package animals;

/**
 * Class to represent Cow
 * @author Alex Burling(arb142)
 */
public class Cow extends Animal {
	
	public final static String COW_NAME = "Cow";
	public final static String COW_DESC = "MOO";
	public final static float COW_PRICE = 2;
	public final static float COW_DAILY_PROF = 100;
	public final static float COW_BASE_HEALTH = 5;
	public final static float COW_BASE_MOOD = 5;
	
	/**
	 * Constructs the Cow object from public constant values defined in Cow.java
	 * Every Cow object is a deepcopy of each other (same attribute values and structure, but different objects)
	 * TODO excluding name? allow custom names?
	 */
	public Cow() {
		super(COW_NAME, COW_DESC, COW_PRICE, COW_DAILY_PROF, COW_BASE_HEALTH, COW_BASE_MOOD);
	}
}
