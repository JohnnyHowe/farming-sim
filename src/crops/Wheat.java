package crops;

/**
 * Class to represent Wheat
 * @author Alex Burling(arb142)
 */
public class Wheat extends Crop {
	
	public final static String WHEAT_NAME = "Wheat";		//Display Name
	public final static String WHEAT_DESC = "Wheaty wheat";	//Description
	public final static float WHEAT_PRICE = 2;				//Base Price
	public final static float WHEAT_INCOME = 100;			//Money gained by player on harvest
	
	/**
	 * Constructs the Wheat object from public constant values defined in Wheat.java
	 * Every Wheat object is a deepcopy of each other (same attribute values and structure, but different objects)
	 * TODO excluding name? allow custom names?
	 */
    public Wheat() {
		super(WHEAT_NAME, WHEAT_DESC, WHEAT_PRICE, WHEAT_INCOME);
	}
}