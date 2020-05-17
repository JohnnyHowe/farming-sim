package items;

/**
 * Class to represent Brewing Stand Item
 * Item functions in game as a daily action booster
 * @see CropList
 */
public class BrewingStand extends Item {
	
	public final static String STAND_NAME = "Brewing Stand";	
	public final static String STAND_DESC = "Quick drink this";	
	public final static float STAND_PRICE = 2;			
	public final static String STAND_EFFECT = "health";		
	public final static float STAND_MULT = 2;	
	
	public BrewingStand() {
		super(STAND_NAME, STAND_DESC, STAND_PRICE, STAND_EFFECT, STAND_MULT);
	}
}
