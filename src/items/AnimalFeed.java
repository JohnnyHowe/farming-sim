package items;

/**
 * Class to represent Animal Feed Item.
 * Item functions in game as a daily action booster.
 * @see Item
 */
public class AnimalFeed extends Item {
	
	public final static String FEED_NAME = "Feed Bag";	
	public final static String FEED_DESC = "Animal Feed";	
	public final static float FEED_PRICE = 2;			
	public final static String FEED_EFFECT = "health";		
	public final static float FEED_MULT = 2;	
	
	/**
	 * Constructs the Animal feed object from public constant values defined in AnimalFeed.java.
	 * Every Animal feed object is a deepcopy of each other (same attribute values and structure, but different objects)
	 */
	public AnimalFeed() {
		super(FEED_NAME, FEED_DESC, FEED_PRICE, FEED_EFFECT, FEED_MULT);
	}
}
