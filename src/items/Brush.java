package items;

/**
 * Class to represent Brush Item
 * Item functions in game as a daily action booster
 * @see Item
 */
public class Brush extends Item {
	
	public final static String BRUSH_NAME = "Brush";		
	public final static String BRUSH_DESC = "For brushing";		
	public final static float BRUSH_PRICE = 2;			
	public final static String BRUSH_EFFECT = "mood";	
	public final static float BRUSH_MULT = 2;		
	
	/**
	 * Constructs the Brush object from public constant values defined in Brush.java.
	 * Every Brush object is a deepcopy of each other (same attribute values and structure, but different objects)
	 */
	public Brush() {
		super(BRUSH_NAME, BRUSH_DESC, BRUSH_PRICE, BRUSH_EFFECT, BRUSH_MULT);
	}
}
