package farm;

import java.util.Dictionary;
import java.util.Hashtable;

import animals.*;
import crops.*;
import farm.FarmItem.FarmItems;
import items.*;

/**
 * Abstract Java Class responsible for generating game objects for various uses,
 * e.g. supplying the store with duplicate items for the players inventory
 * Follows a standard Factory design pattern
 * @author Alex Burling(arb142)
 */
public abstract class ItemFactory {
	
	/**
	 * Supplies a Dictionary of all available Animal objects within
	 * the game, keyed with a String that is the Animal's "name"
	 * @return Dictionary<String, Animal> a dictionary containing every Animal object
	 */
	public static Dictionary<FarmItems, Animal> GetAllAnimals() {
		Dictionary<FarmItems, Animal> allAnimals = new Hashtable<FarmItems, Animal>();

		allAnimals.put(FarmItems.COW, new Cow());
		allAnimals.put(FarmItems.SHEEP, new Sheep());
		allAnimals.put(FarmItems.CHICKEN, new Chicken());

		return allAnimals;
	}
	
	/**
	 * Supplies a Dictionary of all available Crop objects within
	 * the game, keyed with a String that is the Crops's "name"
	 * @return Dictionary<String, Crop> a dictionary containing every Crop object
	 */
	public static Dictionary<FarmItems, Crop> GetAllCrops() {
		Dictionary<FarmItems, Crop> allCrops = new Hashtable<FarmItems, Crop>();

		allCrops.put(FarmItems.WHEAT, new Wheat());
		allCrops.put(FarmItems.SUGAR_CANE, new SugarCane());
		allCrops.put(FarmItems.CACTUS, new Cactus());
		allCrops.put(FarmItems.MUSHROOM, new Mushroom());
		allCrops.put(FarmItems.MELON, new Melon());
		allCrops.put(FarmItems.PUMPKIN, new Pumpkin());

		return allCrops;
	}
	
	/**
	 * Supplies a Dictionary of all available Item objects within
	 * the game, keyed with a String that is the Items's "name"
	 * @return Dictionary<String, Item> a dictionary containing every Item object
	 */
	public static Dictionary<FarmItems, Item> GetAllItems() {
		Dictionary<FarmItems, Item> allItems = new Hashtable<FarmItems, Item>();

		allItems.put(FarmItems.GRAIN, new Grain());
		allItems.put(FarmItems.FEED_BAG, new FeedBag());
		allItems.put(FarmItems.BONEMEAL, new Bonemeal());//test items
		allItems.put(FarmItems.FERTILISER, new Fertiliser());
		allItems.put(FarmItems.BRUSH, new Brush());
		allItems.put(FarmItems.SHAMPOO, new Shampoo());

		return allItems;
	}

	/**
	 * Given an item as an object, return a new instance of the item
	 * Overloaded function signature, call as
     * GetNew(String name) to get item from a String
	 * @param item FarmItem Object to create (eg. "Wheat")
	 * @return FarmItem the corresponding requested FarmItem
	 */
	public static FarmItem GetNew(FarmItem item) {
		return GetNew(item.getEnum());
	}

	/**
	 * Given the name of an item as a string, return a new instance of the item
	 * Overloaded function signature, call as
     * GetNew(FarmItem item) to get item from an object
	 * TODO change implementation to use instanceof to support naming animal i.e. cow.name = 'Bessie'?
	 * @param name name of item to create (eg. "Wheat")
	 * @return FarmItem the corresponding requested FarmItem
	 */
	public static FarmItem GetNew(FarmItems name) {
		switch (name) {
			case COW:
				return new Cow();
				
			case SHEEP:
				return new Sheep();
				
			case CHICKEN:
				return new Chicken();
				
			case CACTUS:
				return new Cactus();
				
			case MELON:
				return new Melon();
				
			case MUSHROOM:
				return new Mushroom();
				
			case PUMPKIN:
				return new Pumpkin();
			
			case SUGAR_CANE:
				return new SugarCane();
				
			case WHEAT:
				return new Wheat();
				
			case GRAIN:
				return new Grain();
				
			case FEED_BAG:
				return new FeedBag();
				
			case BONEMEAL:
				return new Bonemeal();
				
			case FERTILISER:
				return new Fertiliser();
			
			case BRUSH:
				return new Brush();
				
			case SHAMPOO:
				return new Shampoo();
		}
		System.out.println("Couldn't find item " + name);
		return new Wheat(); //must return a FarmItem as stated in function def
	}
}
