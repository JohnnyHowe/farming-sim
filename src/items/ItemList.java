package items;

import java.util.Dictionary;
import java.util.Hashtable;

public abstract class ItemList {

	public static Dictionary<String, Item> GetAllItems() {
		Dictionary<String, Item> allItems = new Hashtable<String, Item>();

		allItems.put("bonemeal", new Item("Bonemeal", "spooky", 69, "growth", 2));//test items
		allItems.put("brush", new Item("Brush", "for brushing", 69, "happiness", 2));
		allItems.put("brewing stand", new Item("Brewing Stand", "quick drink this", 69, "health", 2));
		allItems.put("golems rose", new Item("Poppy", "It comes from the northern iron farms", 69, "income", 2));

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
	public final static String BONE_NAME = "Brush";		
	public final static String BONE_DESC = "Spooky";		
	public final static double BONE_PRICE = 2;			
	public final static String BONE_EFFECT = "growth";	
	public final static double BONE_MULT = 2;				
	
	public final static String BONE_NAME = "Bonemeal";	
	public final static String BONE_DESC = "Spooky";	
	public final static double BONE_PRICE = 2;			
	public final static String BONE_EFFECT = "growth";		
	public final static double BONE_MULT = 2;			
	
	public final static String BONE_NAME = "Bonemeal";		
	public final static String BONE_DESC = "Spooky";		
	public final static double BONE_PRICE = 2;				
	public final static String BONE_EFFECT = "growth";		
	public final static double BONE_MULT = 2;				
	

}
