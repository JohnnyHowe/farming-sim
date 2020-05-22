package items;

import farm.FarmItem;

/**
 * Class for representing a useable Item.
 * Generally used to boost daily actions
 * @author Alex Burling(arb142), Jonathon Howe(joh29)
 * @see AnimalFeed
 * @see Bonemeal
 * @see Brush
 * @see GolemRose
 */
public class Item extends FarmItem {
	
	private String effect;
	private float effectMultiplier;

	public Item(String name, String description, float price, String effect, float effectMultiplier) {
		super(name, description, price);
		this.effect = effect;
		this.effectMultiplier = effectMultiplier;
	}
	
	public String getEffect() {
		return this.effect;
	}
	
	public float getMod() {
		return this.effectMultiplier;
	}

	/**
	 * Implements superclass abstract method
	 * At the end of the day, Item's shouldn't change anything about the farm
	 * (as they are consumables used with player actions) this is just an
	 * empty method. Must exist for: ((for FarmItem item: farmitems): item.endDay()).
	 */
	public void endDay() {
		;
	}

}
