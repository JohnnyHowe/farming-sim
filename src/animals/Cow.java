package animals;

/**
 * Class to represent Cow
 */
public class Cow extends Animal {
	
	public final static String COW_NAME = "Cow";
	public final static String COW_DESC = "MOO";
	public final static double COW_PRICE = 2;
	public final static double COW_DAILY_PROF = 100;
	public final static double COW_BASE_HEALTH = 5;
	public final static double COW_BASE_MOOD = 5;
	
	public Cow() {
		super(COW_NAME, COW_DESC, COW_PRICE, COW_DAILY_PROF, COW_BASE_HEALTH, COW_BASE_MOOD);
	}
}
