package animals;

import farmSim.FarmItem;
import farmSim.Game;

public class Animal extends FarmItem {
	
	private double dailyProfit;
	private double health;
	private double mood;
	
	public Animal(String name, String description, double price, double dailyProfit, double health, double mood) {
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
