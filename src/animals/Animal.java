package animals;

import farmSim.FarmItem;
import farmSim.Game;
import items.Item;

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
		mood -= 0.5 / Game.farm.cleanliness; //unclean environment?
		if (health == 0) { //animal dies/runs away?
			Game.farm.removeFarmItem(this);
		} else if (health < 2) { //animal hungry/hurt so gets uspet
			mood -= 1;
		}
		Game.farmer.addMoney(dailyProfit * health * mood);
	}
	
    /*
     * Handles feeding the animal as a daily action
     * Overloaded function signature, call as
     * feed(Item item) to feed with an item
     */
    public void feed() {
    	this.health += 1;	//fed with default / wheat chaff??
    }
    
    /*
     * Handles feeding the animal as a daily action
     * Overloaded function signature, call as
     * feed() to feed with excess organics i.e. crop offcuts (no item)
     */
    public void feed(Item item) {
    	if (item.getEffect().equals("health")) {
    		this.health += item.getMod() * 1; //fed with item
    		Game.farm.removeFarmItem(item);
    	} else {
    		System.out.println("That item cant be used on animals in this way!");
    	} 
    }
	
    /*
     * Handles playing with the animal as a daily action
     * Overloaded function signature, call as
     * play(Item item) to play with an item
     */
	public void play() {
		this.mood += 1 * Game.farm.happinessMod ; //play with animals/pat
	}
	
    /*
     * Handles playing with the animal as a daily action
     * Overloaded function signature, call as
     * play() to play without an item i.e pat animal (no item)
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
