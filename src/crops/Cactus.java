package crops;

/**
 * Class to represent Cactus
 */
public class Cactus extends Crop {
	
	public final static String CACTUS_NAME = "Cactus";
	public final static String CACTUS_DESC = "Ouch, Prickly";
	public final static float CACTUS_PRICE = 5;
	public final static float CACTUS_INCOME = 250;
	
    public Cactus() {
		super(CACTUS_NAME, CACTUS_DESC, CACTUS_PRICE, CACTUS_INCOME);
	}
}