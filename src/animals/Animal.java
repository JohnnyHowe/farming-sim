package animals;

import farmSim.FarmItem;

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

}
