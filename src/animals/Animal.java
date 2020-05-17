package animals;

import farmSim.FarmItem;
import farmSim.Game;

public class Animal extends FarmItem {
	
	private float dailyProfit;
	private float health;
	private float mood;
	
	public Animal(String name, String description, float price, float dailyProfit, float health, float mood) {
		super(name, description, price);
		this.dailyProfit = dailyProfit;
		this.health = health;
		this.mood = mood;
	}
	
	public void endDay() {
		health -= 1; //gets hungry
		mood -= 0.5 * Game.farm.happinessMod; //misses farmer
		if (health == 0) { //animal dies/runs away?
			Game.farm.removeFarmItem(this);
		} else if (health < 2) { //animal hungry/hurt so gets uspet
			mood -= 1;
		}
		Game.farmer.addMoney(dailyProfit * health * mood);
	}
}
