package crops;

/**
 * Structure and attribute subclass to construct Pumpkin objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 * 
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Crop
 */
public class Pumpkin extends Crop {
	
	private final static String PUMP_NAME = "Pumpkin";
	private final static String PUMP_DESC = "Carve some eye holes and place on head to defeat Endermen!";
	private final static float PUMP_PRICE = 7;
	private final static float PUMP_INCOME = 350;
	private final static FarmItems PUMP_ENUM = FarmItems.PUMPKIN;
	
    public Pumpkin() {
		super(PUMP_NAME, PUMP_DESC, PUMP_PRICE, PUMP_INCOME, PUMP_ENUM);
	}
}
