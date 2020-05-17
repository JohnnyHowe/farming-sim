package animals;

import farmSim.FarmItem;
import farmSim.Game;
import items.Item;

/**
 * Class for representing an Animal.
 * @author Alex Burling(arb142), Jonathon Howe(joh29)
 */
public class Animal extends FarmItem {
	
	private float dailyProfit;
	private float health;
	private float mood;
	
	/**
	 * Constructs the Animal from the FarmItem constructor and animal specific values (dailyProfit, health, mood)
	 * @param name Animal's name, e.g. Cow, Chicken etc
	 * @param description Animal's description, only shown when viewing status of animal
	 * @param price Animal's price, used when buying or selling to store
	 * @param dailyProfit Animal's daily profit, used when calculating the income from each animal (along with health and mood)
	 * @param health Animal's base health, deteriorates daily, used when calculating the income from each animal
	 * @param mood Animal's base mood, deteriorates daily, used when calculating the income from each animal
	 */
	public Animal(String name, String description, float price, float dailyProfit, float health, float mood) {
		super(name, description, price);
		this.dailyProfit = dailyProfit;
		this.health = health;
		this.mood = mood;
	}
	
	/**
	 * Handles end of the day actions
	 * i.e. deteriorates health/hunger, deteriorates mood as a factor of farm cleanliness
	 * checks if animal is dead or injured, and adds money earned from animal
	 */
	public void endDay() {
		health -= 1; //gets hungry
		mood -= 0.5 / Game.farm.cleanliness; //unclean environment?
		if (health == 0) { //animal dies/runs away?
			Game.farm.removeFarmItem(this);
		} else if (health < 2) { //animal hungry/hurt so gets uspet
			mood -= 1;
		}
		Game.farmer.addMoney(dailyProfit * health * mood);
	}
	
	/**
     * Handles feeding the animal as a daily action
     * i.e. increases animal health at no cost
     * Overloaded function signature, call as
     * feed(Item item) to feed with an item
	 */
    public void feed() {
    	this.health += 1;	//fed with default / wheat chaff??
    }
    
    /**
     * Handles feeding the animal as a daily action
     * i.e. increases animal health with an item
     * Overloaded function signature, call as
     * feed() to feed with excess organics i.e. crop offcuts (no item)
     * @param item FarmItem to use while feeding, only accepts items with effect "health"
     */
    public void feed(Item item) {
    	if (item.getEffect().equals("health")) {
    		this.health += item.getMod() * 1; //fed with item
    		Game.farm.removeFarmItem(item);
    	} else {
    		System.out.println("That item cant be used on animals in this way!");
    	} 
    }
	
    /**
     * Handles playing with the animal as a daily action
     * i.e. increases animal mood at no cost
     * Overloaded function signature, call as
     * play(Item item) to play with an item
     */
	public void play() {
		this.mood += 1 * Game.farm.happinessMod ; //play with animals/pat
	}
	
    /**
     * Handles playing with the animal as a daily action
     * i.e. increases animal mood with an item
     * Overloaded function signature, call as
     * play() to play without an item i.e pat animal (no item)
     * @param item FarmItem to use while playing, only accepts items with effect "mood"
     */
	public void play(Item item) {
    	if (item.getEffect().equals("mood")) {
    		this.mood += item.getMod() * 1 * Game.farm.happinessMod; //played with item/brushed animal
    		Game.farm.removeFarmItem(item);
    	} else {
    		System.out.println("That item cant be used on animals in this way!");
    	} 
	}
}
