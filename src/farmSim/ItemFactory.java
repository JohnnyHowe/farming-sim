package farmSim;

import java.util.Dictionary;
import java.util.Hashtable;

import animals.*;
import crops.*;
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
	public static Dictionary<String, Animal> GetAllAnimals() {
		Dictionary<String, Animal> allAnimals = new Hashtable<String, Animal>();

		allAnimals.put(Cow.COW_NAME, new Cow());
		allAnimals.put(Sheep.SHEEP_NAME, new Sheep());
		allAnimals.put(Chicken.CHICKEN_NAME, new Chicken());

		return allAnimals;
	}
	
	/**
	 * Supplies a Dictionary of all available Crop objects within
	 * the game, keyed with a String that is the Crops's "name"
	 * @return Dictionary<String, Crop> a dictionary containing every Crop object
	 */
	public static Dictionary<String, Crop> GetAllCrops() {
		Dictionary<String, Crop> allCrops = new Hashtable<String, Crop>();

		allCrops.put(Wheat.WHEAT_NAME, new Wheat());
		allCrops.put(SugarCane.CANE_NAME, new SugarCane());
		allCrops.put(Cactus.CACTUS_NAME, new Cactus());
		allCrops.put(Mushroom.MUSH_NAME, new Mushroom());
		allCrops.put(Melon.MELON_NAME, new Melon());
		allCrops.put(Pumpkin.PUMP_NAME, new Pumpkin());

		return allCrops;
	}
	
	/**
	 * Supplies a Dictionary of all available Item objects within
	 * the game, keyed with a String that is the Items's "name"
	 * @return Dictionary<String, Item> a dictionary containing every Item object
	 */
	public static Dictionary<String, Item> GetAllItems() {
		Dictionary<String, Item> allItems = new Hashtable<String, Item>();

		allItems.put(Bonemeal.BONE_NAME, new Bonemeal());//test items
		allItems.put(Brush.BRUSH_NAME, new Brush());
		allItems.put(AnimalFeed.FEED_NAME, new AnimalFeed());
		allItems.put(GolemRose.ROSE_NAME, new GolemRose());

		return allItems;
	}

	/**
	 * Given an item as an object, return a new instance of the item
	 * This method overloads GetNew(String name), so that either a String
	 * representing the object, or another object of the same type can be
	 * interpreted
	 * @param item FarmItem Object to create (eg. "Wheat")
	 * @return FarmItem the corresponding requested FarmItem
	 */
	public static FarmItem GetNew(FarmItem item) {
		return GetNew(item.getName().toString());
	}

	/**
	 * Given the name of an item as a string, return a new instance of the item
	 * This method overloads GetNew(String name), so that either a String
	 * representing the object, or another object of the same type can be
	 * interpreted
	 * @param name name of item to create (eg. "Wheat")
	 * @return FarmItem the corresponding requested FarmItem
	 */
	public static FarmItem GetNew(String name) {
		switch (name) {
			case AnimalFeed.FEED_NAME:
				return new AnimalFeed();
			case Bonemeal.BONE_NAME:
				return new Bonemeal();
			case Brush.BRUSH_NAME:
				return new Brush();
			case Cactus.CACTUS_NAME:
				return new Cactus();
			case Chicken.CHICKEN_NAME:
				return new Chicken();
			case Cow.COW_NAME:
				return new Cow();
			case GolemRose.ROSE_NAME:
				return new GolemRose();
			case Melon.MELON_NAME:
				return new Melon();
			case Mushroom.MUSH_NAME:
				return new Mushroom();
			case Pumpkin.PUMP_NAME:
				return new Pumpkin();
			case Sheep.SHEEP_NAME:
				return new Sheep();
			case SugarCane.CANE_NAME:
				return new SugarCane();
			case Wheat.WHEAT_NAME:
				return new Wheat();
			
		}
		System.out.println("Couldn't find item " + name);
		return new Wheat(); //must return a FarmItem as stated in function def
	}
	
	/*
	 * Short temporary test case
	 */
	public static void main(String[] args) {
		FarmItem a = new Bonemeal();
		FarmItem b = ItemFactory.GetNew(a);
		FarmItem c = ItemFactory.GetNew(Bonemeal.BONE_NAME);
		System.out.println(a);//should see three different bonemeal objects
		System.out.println(b);
		System.out.println(c);
		FarmItem d = ItemFactory.GetNew("aaa");
		System.out.println(d);//should recieve a stdout and a wheat object
	}
}
