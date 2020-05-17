package crops;

/**
 * Class to represent Melon
 */
public class Melon extends Crop {
	
	public final static String MELON_NAME = "Melon";
	public final static String MELON_DESC = "Watermelone";
	public final static float MELON_PRICE = 6;
	public final static float MELON_INCOME = 300;
	
    public Melon() {
		super(MELON_NAME, MELON_DESC, MELON_PRICE, MELON_INCOME);
	}
}
