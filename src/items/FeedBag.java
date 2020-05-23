package items;

/**
 * Class to represent Animal Feed Item.
 * Item functions in game as a daily action booster.
 * @see Item
 */
public class FeedBag extends Item {
	
	private final static String FEED_NAME = "Feed Bag";	
	private final static String FEED_DESC = "Bag full of animal feed";	
	private final static float FEED_PRICE = 4;			
	private final static String FEED_EFFECT = "health";		
	private final static float FEED_MULT = 3;	
	
	/**
	 * Constructs the Animal feed object from public constant values defined in AnimalFeed.java.
	 * Every Animal feed object is a deepcopy of each other (same attribute values and structure, but different objects)
	 */
	public FeedBag() {
		super(FEED_NAME, FEED_DESC, FEED_PRICE, FEED_EFFECT, FEED_MULT);
	}
}
