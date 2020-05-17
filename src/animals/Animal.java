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
		//example, test code
		this.health -= 0.01;
		this.mood -= 1 * Game.farm.happinessMod;
		Game.farmer.addMoney(dailyProfit);
	}
}
