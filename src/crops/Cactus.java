package crops;

/**
 * Class to represent Cactus
 * @author Alex Burling(arb142)
 * @see Crop
 */
public class Cactus extends Crop {
	
	public final static String CACTUS_NAME = "Cactus";
	public final static String CACTUS_DESC = "Ouch, Prickly";
	public final static float CACTUS_PRICE = 5;
	public final static float CACTUS_INCOME = 250;
	
	/**
	 * Constructs the Cactus object from public constant values defined in Cactus.java
	 * Every Cactus object is a deepcopy of each other (same attribute values and structure, but different objects)
	 */
    public Cactus() {
		super(CACTUS_NAME, CACTUS_DESC, CACTUS_PRICE, CACTUS_INCOME);
	}
}