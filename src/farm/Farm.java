package farm;

import java.util.ArrayList;

import game.Game;
import items.Item;

/**
 * Class representing the farm.
 * Is the environment for the game.
 */
public class Farm
{
	private String name; //"farm name"
	private double growthMod = 1; //how effective is the farm at growing crops (bonus when growing(end day + tend)) 0->2
	private double happinessMod = 1; //how effective is the farmer at keeping animals happy (bonus when playing) TODO stop mood from decreasing as quickly for higher mod? 0->2
	private double incomeMod = 1; //how effective is the farmer at marketing (increases value of money in addMoney(money) 0->2
	private double cleanliness = 1; //how clean is the farm (effects animal mood) TODO make effect other things too? 1->0
	private ArrayList<FarmItem> paddockItems; //farms "inventory"
	private ArrayList<FarmItem> consumableItems;
	
	/**
	 * Gets the name of the farm
	 * @return name of farm
	 */
	public String getName()
	{
		return this.name;
	}
	
	public void setName(String name) {
		Game.getFarm().name = name;
	}

	/**
	 * Returns a string representation of the farm.
	 * In the form "This is farm {farmName} manned by {farmerName}"
	 * @return string representation of farm
	 */
	public String toString()
	{
		return "This is farm " + Game.getFarm().getName() + " manned by " + Game.getFarmer().getName() + ".";
	}

	/**
	 * Given a farm item, add it to the farm
 	 * @param farmItem item to add
	 */
	public void addFarmItem(FarmItem farmItem) {
		if (farmItem instanceof Item) {
			consumableItems.add(farmItem);
		} else {
			paddockItems.add(farmItem);
		}
	}
	
	/**
	 * Given a farm item, remove it from the farm
 	 * @param farmItem item to remove
	 */
	public void removeFarmItem(FarmItem farmItem) {
		if (farmItem instanceof Item) {
			consumableItems.remove(farmItem);
		} else {
			paddockItems.remove(farmItem);
		}
	}
	
	/**
	 * Returns the farms "inventory"
 	 * @return ArrayList<FarmItem> List of FarmItems the farm "owns"
 	 */
	public ArrayList<FarmItem> getPaddockItems() {
		return paddockItems;
	}
	
	public ArrayList<FarmItem> getConsumables() {
		return consumableItems;
	}
	
	public void cleanUp() {
		cleanliness = 1;
	}
	public void endDay() {
		cleanliness -= 0.2;
	}
	
	public void tend() {
		cleanliness = 1;
	}
	
	public double getMod(String mod) {
		switch (mod) {
			case "growth":
				return growthMod;
			case "happiness":
				return happinessMod;
			case "income":
				return incomeMod;
			case "cleanliness":
				return cleanliness;
			default:
				return 1;
		}
		
	}
	
}


