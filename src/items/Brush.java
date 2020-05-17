package items;

/**
 * Class to represent Brush Item
 * Item functions in game as a daily action booster
 * @see CropList
 */
public class Brush extends Item {
	
	public final static String BRUSH_NAME = "Brush";		
	public final static String BRUSH_DESC = "For brushing";		
	public final static float BRUSH_PRICE = 2;			
	public final static String BRUSH_EFFECT = "happiness";	
	public final static float BRUSH_MULT = 2;		
	
	public Brush() {
		super(BRUSH_NAME, BRUSH_DESC, BRUSH_PRICE, BRUSH_EFFECT, BRUSH_MULT);
	}
}
