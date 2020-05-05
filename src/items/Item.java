package items;

import farmSim.FarmItem;


public class Item extends FarmItem {
	
	private String effect;
	private double effectMultiplier;

	public Item(String name, String description, double price, String effect, double effectMultiplier) {
		super(name, description, price);
		this.effect = effect;
		this.effectMultiplier = effectMultiplier;
	}
	
	public String getEffect() {
		return this.effect;
	}
	
	public double getMod() {
		return this.effectMultiplier;
	}

}
