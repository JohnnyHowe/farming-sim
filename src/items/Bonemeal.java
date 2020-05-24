package items;

/**
 * Structure and attribute subclass to construct Bonemeal objects.
 * <p>
 * This class provides the superclass constructor with the correct
 * parameters, and provides an easy place for them to be set.<br>
 * Every instance of this object is a deep-copy of each other.
 * 
 * @author Alex Burling(arb142)
 * @version 1.0
 * @see Item
 */
public class Bonemeal extends Item {
	
	private final static String BONE_NAME = "Bonemeal";		//Display Name
	private final static String BONE_DESC = "Spooky";		//Description
	private final static float BONE_PRICE = 2;				//Base Price
	private final static String BONE_EFFECT = "growth";		//Item Effect
	private final static float BONE_MULT = 2;
	private final static FarmItems BONE_ENUM = FarmItems.BONEMEAL;
	
	public Bonemeal() {
		super(BONE_NAME, BONE_DESC, BONE_PRICE, BONE_EFFECT, BONE_MULT, BONE_ENUM);
	}
}
