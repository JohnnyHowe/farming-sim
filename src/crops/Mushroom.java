package crops;

/**
 * Class to represent Mushroom
 */
public class Mushroom extends Crop {
	
	public final static String MUSH_NAME = "Mushroom";
	public final static String MUSH_DESC = "Kind of, mushy...";
	public final static float MUSH_PRICE = 4;
	public final static float MUSH_INCOME = 200;
	public final static float MUSH_THRESHOLD = 5;
	
    public Mushroom() {
		super(MUSH_NAME, MUSH_DESC, MUSH_PRICE, MUSH_INCOME, MUSH_THRESHOLD);
	}
}
