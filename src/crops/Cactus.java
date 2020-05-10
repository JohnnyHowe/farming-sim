package crops;

/**
 * Class to represent Cactus
 */
public class Cactus extends Crop {
	
	public final static String CACTUS_NAME = "Cactus";
	public final static String CACTUS_DESC = "Ouch, Prickly";
	public final static double CACTUS_PRICE = 5;
	public final static double CACTUS_INCOME = 250;
	public final static double CACTUS_THRESHOLD = 5;	
	
    public Cactus() {
		super(CACTUS_NAME, CACTUS_DESC, CACTUS_PRICE, CACTUS_INCOME, CACTUS_THRESHOLD);
	}
}
