package items;

import java.util.Dictionary;
import java.util.Hashtable;

public abstract class ItemList {

	public static Dictionary<String, Item> GetAllItems() {
		Dictionary<String, Item> allItems = new Hashtable<String, Item>();

		allItems.put(BONE_NAME, new Bonemeal());//test items
		allItems.put(BRUSH_NAME, new Brush());
		allItems.put(STAND_NAME, new BrewingStand());
		allItems.put(ROSE_NAME, new GolemRose());

		return allItems;
	}
	
	/*
	 * Static, Constant definitions of item attributes (promotes consistency and removal of "magic numbers"
	 * ALL VALUES ARE PLACEHOLDER
	 * feel free to change as needed
	 */
	
	//BONEMEAL
	public final static String BONE_NAME = "Bonemeal";		//Display Name
	public final static String BONE_DESC = "Spooky";		//Description
	public final static double BONE_PRICE = 2;				//Base Price
	public final static String BONE_EFFECT = "growth";		//Item Effect
	public final static double BONE_MULT = 2;				//Effect Multiplier
	
	//BRUSH
	public final static String BRUSH_NAME = "Brush";		
	public final static String BRUSH_DESC = "For brushing";		
	public final static double BRUSH_PRICE = 2;			
	public final static String BRUSH_EFFECT = "happiness";	
	public final static double BRUSH_MULT = 2;				
	
	//BREWINGSTAND
	public final static String STAND_NAME = "Brewing Stand";	
	public final static String STAND_DESC = "Quick drink this";	
	public final static double STAND_PRICE = 2;			
	public final static String STAND_EFFECT = "health";		
	public final static double STAND_MULT = 2;			
	
	//GOLEM"SROSE
	public final static String ROSE_NAME = "Golem's Rose";		
	public final static String ROSE_DESC = "It comes from the northern iron farms";		
	public final static double ROSE_PRICE = 2;				
	public final static String ROSE_EFFECT = "Income";		
	public final static double ROSE_MULT = 2;				
	

}
