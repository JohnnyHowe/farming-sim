package animals;

/**
 * Class to represent Sheep
 * @author Alex Burling(arb142)
 * @see Animal
 */
public class Sheep extends Animal {
	
	public final static String SHEEP_NAME = "Sheep";
	public final static String SHEEP_DESC = "BAA";
	public final static float SHEEP_PRICE = 2;
	public final static float SHEEP_DAILY_PROF = 100;
	public final static float SHEEP_BASE_HEALTH = 5;
	public final static float SHEEP_BASE_MOOD = 5;
	
	/**
	 * Constructs the Sheep object from public constant values defined in Sheep.java
	 * Every Sheep object is a deepcopy of each other (same attribute values and structure, but different objects)
	 * TODO excluding name? allow custom names?
	 */
	public Sheep() {
		super(SHEEP_NAME, SHEEP_DESC, SHEEP_PRICE, SHEEP_DAILY_PROF, SHEEP_BASE_HEALTH, SHEEP_BASE_MOOD);
	}
}
