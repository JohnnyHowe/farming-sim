package animals;

/**
 * Structure and attribute subclass to construct Sheep objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 *  
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Animal
 */
public class Sheep extends Animal {
	
	private final static String SHEEP_NAME = "Sheep";
	private final static String SHEEP_DESC = "BAA";
	private final static float SHEEP_PRICE = 2;
	private final static float SHEEP_DAILY_PROF = 100;
	private final static float SHEEP_BASE_HEALTH = 5;
	private final static float SHEEP_BASE_MOOD = 5;
	private final static FarmItems SHEEP_ENUM = FarmItems.SHEEP;
	
	public Sheep() {
		super(SHEEP_NAME, SHEEP_DESC, SHEEP_PRICE, SHEEP_DAILY_PROF, SHEEP_BASE_HEALTH, SHEEP_BASE_MOOD, SHEEP_ENUM);
	}
}
