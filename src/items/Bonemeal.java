package items;

/**
 * Class to represent Bonemeal Item
 * Item functions in game as a daily action booster
 * @see CropList
 */
public class Bonemeal extends Item {
	
	public final static String BONE_NAME = "Bonemeal";		//Display Name
	public final static String BONE_DESC = "Spooky";		//Description
	public final static float BONE_PRICE = 2;				//Base Price
	public final static String BONE_EFFECT = "growth";		//Item Effect
	public final static float BONE_MULT = 2;
	
	public Bonemeal() {
		super(BONE_NAME, BONE_DESC, BONE_PRICE, BONE_EFFECT, BONE_MULT);
	}
}
