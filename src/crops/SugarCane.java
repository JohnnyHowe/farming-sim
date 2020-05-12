package crops;

/**
 * Class to represent Sugar Cane
 */
public class SugarCane extends Crop {
	
	public final static String CANE_NAME = "Sugar Cane";
	public final static String CANE_DESC = "Sugary cane";
	public final static float CANE_PRICE = 3;
	public final static float CANE_INCOME = 150;
	public final static float CANE_THRESHOLD = 5;
	
    public SugarCane() {
		super(CANE_NAME, CANE_DESC, CANE_PRICE, CANE_INCOME, CANE_THRESHOLD);
	}
}