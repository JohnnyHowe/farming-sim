package items;

/**
 * Structure and attribute subclass to construct Brush objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 * 
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Item
 */
public class Brush extends Item {
	
	private final static String BRUSH_NAME = "Brush";		
	private final static String BRUSH_DESC = "For brushing";		
	private final static float BRUSH_PRICE = 2;			
	private final static String BRUSH_EFFECT = "mood";	
	private final static float BRUSH_MULT = 2;		
	private final static FarmItems BRUSH_ENUM = FarmItems.BRUSH;

	public Brush() {
		super(BRUSH_NAME, BRUSH_DESC, BRUSH_PRICE, BRUSH_EFFECT, BRUSH_MULT, BRUSH_ENUM);
	}
}
