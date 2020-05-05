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
	

}
