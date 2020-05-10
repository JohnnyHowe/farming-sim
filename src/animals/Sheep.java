package animals;

/**
 * Class to represent Sheep
 */
public class Sheep extends Animal {
	
	public final static String SHEEP_NAME = "Sheep";
	public final static String SHEEP_DESC = "BAA";
	public final static double SHEEP_PRICE = 2;
	public final static double SHEEP_DAILY_PROF = 100;
	public final static double SHEEP_BASE_HEALTH = 5;
	public final static double SHEEP_BASE_MOOD = 5;
	
	public Sheep() {
		super(SHEEP_NAME, SHEEP_DESC, SHEEP_PRICE, SHEEP_DAILY_PROF, SHEEP_BASE_HEALTH, SHEEP_BASE_MOOD);
	}
}
