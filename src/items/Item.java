package items;

import farmSim.FarmItem;
import farmSim.Game;


public class Item extends FarmItem {
	
	private String effect;
	private int effectMultiplier;

	public Item(String name, String description, double price, String effect, int effectMultiplier) {
		super(name, description, price);
		this.effect = effect;
		this.effectMultiplier = effectMultiplier;
	}
	
	public String getEffect() {
		return this.effect;
	}
	
	public int getMod() {
		return this.effectMultiplier;
	}

}
