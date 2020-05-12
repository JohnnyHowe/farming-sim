package crops;

/**
 * Class to represent Pumpkin
 */
public class Pumpkin extends Crop {
	
	public final static String PUMP_NAME = "Pumpkin";
	public final static String PUMP_DESC = "Carve and place on head to defeat Endermen!";
	public final static float PUMP_PRICE = 7;
	public final static float PUMP_INCOME = 350;
	public final static float PUMP_THRESHOLD = 5;
	
    public Pumpkin() {
		super(PUMP_NAME, PUMP_DESC, PUMP_PRICE, PUMP_INCOME, PUMP_THRESHOLD);
	}
}
