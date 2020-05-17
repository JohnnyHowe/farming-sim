package items;

import farmSim.FarmItem;


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

}
