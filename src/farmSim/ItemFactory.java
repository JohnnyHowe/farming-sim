package farmSim;

import java.util.Dictionary;
import java.util.Hashtable;

import animals.*;
import crops.*;
import items.*;

public abstract class ItemFactory {
	
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
	
	public static FarmItem get(FarmItem item) {
		return get(item.getName().toString());
	}
	
	public static FarmItem get(String name) {
		switch (name) {
			case Bonemeal.BONE_NAME:
				return new Bonemeal();
			case BrewingStand.STAND_NAME:
				return new BrewingStand();
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
			default:
				System.out.println("ERROR");
				return new Wheat();
		}
	}
	
	public static void main(String[] args) {
		FarmItem a = new Bonemeal();
		FarmItem b = ItemFactory.get(a);
		FarmItem c = ItemFactory.get(Bonemeal.BONE_NAME);
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		FarmItem d = ItemFactory.get("aaa");
		System.out.println(d);
	}
}
