package items;

/**
 * Structure and attribute subclass to construct Grain objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 * 
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Item
 */
public class Grain extends Item {

	private final static String GRAIN_NAME = "Grain";		
	private final static String GRAIN_DESC = "A small handful of grain and seeds";		
	private final static float GRAIN_PRICE = 2;			
	private final static String GRAIN_EFFECT = "health";	
	private final static float GRAIN_MULT = 2;	
	private final static FarmItems GRAIN_ENUM = FarmItems.GRAIN;
	
	public Grain(){
		super(GRAIN_NAME, GRAIN_DESC, GRAIN_PRICE, GRAIN_EFFECT, GRAIN_MULT, GRAIN_ENUM);
	}

}
