package items;

/**
 * Structure and attribute subclass to construct FeedBag objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 * 
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Item
 */
public class FeedBag extends Item {
	
	private final static String FEED_NAME = "Feed Bag";	
	private final static String FEED_DESC = "Bag full of animal feed";	
	private final static float FEED_PRICE = 4;			
	private final static String FEED_EFFECT = "health";		
	private final static float FEED_MULT = 3;	
	private final static FarmItems FEED_ENUM = FarmItems.FEED_BAG;
	
	public FeedBag() {
		super(FEED_NAME, FEED_DESC, FEED_PRICE, FEED_EFFECT, FEED_MULT, FEED_ENUM);
	}
}
