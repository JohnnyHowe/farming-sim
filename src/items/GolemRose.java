package items;

/**
 * Class to represent Golem Rose Item
 * Item functions in game as a daily action booster
 * @see Item
 */
public class GolemRose extends Item {
	
	public final static String ROSE_NAME = "Golem's Rose";		
	public final static String ROSE_DESC = "It comes from the northern iron farms";		
	public final static float ROSE_PRICE = 2;				
	public final static String ROSE_EFFECT = "income";		
	public final static float ROSE_MULT = 2;	
	
	/**
	 * Constructs the GolemRose object from public constant values defined in GolemRose.java.
	 * Every GolemRose object is a deepcopy of each other (same attribute values and structure, but different objects)
	 */
	public GolemRose() {
		super(ROSE_NAME, ROSE_DESC, ROSE_PRICE, ROSE_EFFECT, ROSE_MULT);
	}
}
