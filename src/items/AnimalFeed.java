package items;

/**
 * Class to represent Brewing FEED Item
 * Item functions in game as a daily action booster
 * @see CropList
 */
public class AnimalFeed extends Item {
	
	public final static String FEED_NAME = "Feed Bag";	
	public final static String FEED_DESC = "Animal Feed";	
	public final static float FEED_PRICE = 2;			
	public final static String FEED_EFFECT = "health";		
	public final static float FEED_MULT = 2;	
	
	public AnimalFeed() {
		super(FEED_NAME, FEED_DESC, FEED_PRICE, FEED_EFFECT, FEED_MULT);
	}
}
