package items;

/**
 * Class to represent Golem Rose Item
 * Item functions in game as a daily action booster
 * @see CropList
 */
public class GolemRose extends Item {
	
	public final static String ROSE_NAME = "Golem's Rose";		
	public final static String ROSE_DESC = "It comes from the northern iron farms";		
	public final static float ROSE_PRICE = 2;				
	public final static String ROSE_EFFECT = "income";		
	public final static float ROSE_MULT = 2;	
	
	public GolemRose() {
		super(ROSE_NAME, ROSE_DESC, ROSE_PRICE, ROSE_EFFECT, ROSE_MULT);
	}
}
