package animals;

import exceptions.InvalidItemException;
import farm.FarmItem;
import game.Game;
import items.Item;

/**
 * Logic and structure superclass to construct different animals.
 * <p>
 * This class provides each animal with the logic and structure required, by
 * expanding on the FarmItem structure.<br>
 * Animals function as a daily income (rewarded at {@link #endDay}) and require 
 * feeding and playing with to keep health and mood high.
 * 
 * @version 1.0
 * @author Alex Burling(arb142)
 * @see FarmItem
 * @see Chicken
 * @see Cow
 * @see Sheep
 */
public abstract class Animal extends FarmItem {
	
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
	public Animal(String name, String description, float price, float dailyProfit, float health, float mood, FarmItems selfEnum) {
		super(name, description, price, selfEnum);
		this.dailyProfit = dailyProfit;
		this.health = health;
		this.mood = mood;
	}
	
	/**
	 * Handles end of the day actions
	 * i.e. deteriorates health/hunger, deteriorates mood as a factor of farm cleanliness
	 * checks if animal is dead or injured, and adds money earned from animal.
	 * Implements superclass abstract method 
	 */
	@Override
	public void endDay() {
		health -= 1; //gets hungry
		mood -= 0.5 / Game.getFarm().cleanliness; //unclean environment?
		if (health == 0) { //animal dies/runs away?
			Game.getFarm().removeFarmItem(this);
		} else if (health < 2) { //animal hungry/hurt so gets uspet
			mood -= 1;
		}
		Game.getFarmer().addMoney(dailyProfit * health * mood);
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
     * @throws InvalidItemException 
     */
    public void feed(Item item) throws InvalidItemException {
    	if (item.getEffect().equals("health")) {
    		this.health += item.getMod() * 1; //fed with item
    		Game.getFarm().removeFarmItem(item);
    	} else {
    		throw new InvalidItemException();
    	} 
    }
	
    /**
     * Handles playing with the animal as a daily action
     * i.e. increases animal mood at no cost
     * Overloaded function signature, call as
     * play(Item item) to play with an item
     */
	public void play() {
		this.mood += 1 * Game.getFarm().happinessMod ; //play with animals/pat
	}
	
    /**
     * Handles playing with the animal as a daily action
     * i.e. increases animal mood with an item
     * Overloaded function signature, call as
     * play() to play without an item i.e pat animal (no item)
     * @param item FarmItem to use while playing, only accepts items with effect "mood"
     * @throws InvalidItemException 
     */
	public void play(Item item) throws InvalidItemException {
    	if (item.getEffect().equals("mood")) {
    		this.mood += item.getMod() * 1 * Game.getFarm().happinessMod; //played with item/brushed animal
    		Game.getFarm().removeFarmItem(item);
    	} else {
    		throw new InvalidItemException();
    	} 
	}
}
