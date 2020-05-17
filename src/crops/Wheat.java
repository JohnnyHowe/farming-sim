package crops;

/**
 * Class to represent Wheat
 */
public class Wheat extends Crop {
	
	public final static String WHEAT_NAME = "Wheat";		//Display Name
	public final static String WHEAT_DESC = "Wheaty wheat";	//Description
	public final static float WHEAT_PRICE = 2;				//Base Price
	public final static float WHEAT_INCOME = 100;			//Money gained by player on harvest
	
    public Wheat() {
		super(WHEAT_NAME, WHEAT_DESC, WHEAT_PRICE, WHEAT_INCOME);
	}
}