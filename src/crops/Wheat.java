package crops;

/**
 * Class to represent Wheat
 */
public class Wheat extends Crop {
	
	public final static String WHEAT_NAME = "Wheat";		//Display Name
	public final static String WHEAT_DESC = "Wheaty wheat";	//Description
	public final static double WHEAT_PRICE = 2;				//Base Price
	public final static double WHEAT_INCOME = 100;			//Money gained by player on harvest
	public final static double WHEAT_THRESHOLD = 5;
	
    public Wheat() {
		super(WHEAT_NAME, WHEAT_DESC, WHEAT_PRICE, WHEAT_INCOME, WHEAT_THRESHOLD);
	}
}