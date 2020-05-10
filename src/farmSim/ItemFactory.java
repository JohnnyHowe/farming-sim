package farmSim;

import java.util.Dictionary;
import java.util.Hashtable;

import animals.*;
import crops.*;
import items.*;

public class ItemFactory {
	
	public static Dictionary<String, Animal> GetAllAnimals() {
		Dictionary<String, Animal> allAnimals = new Hashtable<String, Animal>();

		allAnimals.put(Cow.COW_NAME, new Cow());
		allAnimals.put(Sheep.SHEEP_NAME, new Sheep());
		allAnimals.put(Chicken.CHICKEN_NAME, new Chicken());

		return allAnimals;
	}
	
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
	
	public static Dictionary<String, Item> GetAllItems() {
		Dictionary<String, Item> allItems = new Hashtable<String, Item>();

		allItems.put(Bonemeal.BONE_NAME, new Bonemeal());//test items
		allItems.put(Brush.BRUSH_NAME, new Brush());
		allItems.put(BrewingStand.STAND_NAME, new BrewingStand());
		allItems.put(GolemRose.ROSE_NAME, new GolemRose());

		return allItems;
	}
}
