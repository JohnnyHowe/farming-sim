package animals;

/**
 * Structure and attribute subclass to construct Chicken objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 * 
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Animal
 */
public class Chicken extends Animal {
	
	private final static String CHICKEN_NAME = "Chicken";
	private final static String CHICKEN_DESC = "CLUCK";
	private final static float CHICKEN_PRICE = 2;
	private final static float CHICKEN_DAILY_PROF = 100;
	private final static float CHICKEN_BASE_HEALTH = 5;
	private final static float CHICKEN_BASE_MOOD = 5;
	private final static FarmItems CHICKEN_ENUM = FarmItems.CHICKEN;
	
	public Chicken() {
		super(CHICKEN_NAME, CHICKEN_DESC, CHICKEN_PRICE, CHICKEN_DAILY_PROF, CHICKEN_BASE_HEALTH, CHICKEN_BASE_MOOD, CHICKEN_ENUM);
	}
}
