package items;

/**
 * Class to represent Brush Item
 * Item functions in game as a daily action booster
 * @see Item
 */
public class Brush extends Item {
	
	private final static String BRUSH_NAME = "Brush";		
	private final static String BRUSH_DESC = "For brushing";		
	private final static float BRUSH_PRICE = 2;			
	private final static String BRUSH_EFFECT = "mood";	
	private final static float BRUSH_MULT = 2;		
	private final static FarmItems BRUSH_ENUM = FarmItems.BRUSH;
	
	/**
	 * Constructs the Brush object from public constant values defined in Brush.java.
	 * Every Brush object is a deepcopy of each other (same attribute values and structure, but different objects)
	 */
	public Brush() {
		super(BRUSH_NAME, BRUSH_DESC, BRUSH_PRICE, BRUSH_EFFECT, BRUSH_MULT, BRUSH_ENUM);
	}
}
