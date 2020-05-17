package animals;

/**
 * Class to represent Chicken
 */
public class Chicken extends Animal {
	
	public final static String CHICKEN_NAME = "Chicken";
	public final static String CHICKEN_DESC = "CLUCK";
	public final static float CHICKEN_PRICE = 2;
	public final static float CHICKEN_DAILY_PROF = 100;
	public final static float CHICKEN_BASE_HEALTH = 5;
	public final static float CHICKEN_BASE_MOOD = 5;
	
	public Chicken() {
		super(CHICKEN_NAME, CHICKEN_DESC, CHICKEN_PRICE, CHICKEN_DAILY_PROF, CHICKEN_BASE_HEALTH, CHICKEN_BASE_MOOD);
	}
}
