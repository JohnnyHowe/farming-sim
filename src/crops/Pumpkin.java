package crops;

/**
 * Class to represent Pumpkin
 * @author Alex Burling(arb142)
 * @see Crop
 */
public class Pumpkin extends Crop {
	
	public final static String PUMP_NAME = "Pumpkin";
	public final static String PUMP_DESC = "Carve and place on head to defeat Endermen!";
	public final static float PUMP_PRICE = 7;
	public final static float PUMP_INCOME = 350;
	
	/**
	 * Constructs the Pumpkin object from public constant values defined in Pumpkin.java
	 * Every Pumpkin object is a deepcopy of each other (same attribute values and structure, but different objects)
	 */
    public Pumpkin() {
		super(PUMP_NAME, PUMP_DESC, PUMP_PRICE, PUMP_INCOME);
	}
}
