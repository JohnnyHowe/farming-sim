package crops;

/**
 * Structure and attribute subclass to construct Cactus objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 * 
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Crop
 */
public class Cactus extends Crop {
	
	private final static String CACTUS_NAME = "Cactus";
	private final static String CACTUS_DESC = "Ouch, Prickly";
	private final static float CACTUS_PRICE = 5;
	private final static float CACTUS_INCOME = 250;
	private final static FarmItems CACTUS_ENUM = FarmItems.CACTUS;
	private final static int GROW_TIME = 3;
	
    public Cactus() {
		super(CACTUS_NAME, CACTUS_DESC, CACTUS_PRICE, CACTUS_INCOME,CACTUS_ENUM, GROW_TIME);
	}
}