package animals;

import exceptions.InvalidItemException;
import farm.Farm;
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
 * @see Chicken * @see Cow
 * @see Sheep
 */
public abstract class Animal extends FarmItem {
	
	private float dailyProfit;
	private float health;
	private float mood;

	public enum AnimalMood {
	    SAD, UNHAPPY, CONTENT, HAPPY, VERY_HAPPY
	}

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
	 * Get the daily profit of the animal
	 * @return dailyProfit
	 */
	public float getDailyProfit() {
		return dailyProfit;
	}
	
	public float getHealth() {
		return this.health;
	}
	
	public float getMood() {
		return this.mood;
	}

	/**
	 * Handles end of the day actions for Animal objects
	 * <p>
	 * Every FarmItem subclass must implement an endDay() function, to simplify game loop.
	 * 
	 * This is to handle animal specific logic and attributes.<br>
	 * i.e. deteriorates health and mood, which drop at constant value, and adds profit.<br>
	 * 
	 * However mood will deteriorate faster when low health, and animal will die/run away on 0.<br>
	 * Profit earned at the end of each day is dependent on health, mood, and internal value.
	 */
	@Override
	public void endDay() {
		health -= 0.5;
		mood -= 0.5 / Game.getFarm().getMod("cleanliness");
		Game.getFarmer().addMoney(getCurrentProfit());
	}

	/**
	 * Get the animals profit - Subject to its mood and farm cleanliness
	 * @return profit
	 */
	public float getCurrentProfit() {
		if (health <= 0) {
			Game.getFarm().removeFarmItem(this);
		} else if (health < 2) {
			mood -= 1;
		}
		return mood * health * dailyProfit;
	}

	public AnimalMood getMoodEnum() {
		if (mood < 2) {
			return AnimalMood.SAD;
		} else if (mood < 3) {
			return AnimalMood.UNHAPPY;
		} else if (mood < 4) {
			return AnimalMood.CONTENT;
		} else if (mood < 6) {
			return AnimalMood.HAPPY;
		} else {
		    return  AnimalMood.VERY_HAPPY;
		}
	}

	public String getMoodString() {
		switch (getMoodEnum()) {
			case SAD: return "Sad";
			case UNHAPPY: return "Unhappy";
			case HAPPY: return "Happy";
			case VERY_HAPPY: return "Very Happy";
			default: return "Content";
		}
	}


	/**
	 * Updates object attributes consistent with feeding the animal as a daily action
	 * <p>
	 * This function takes no parameters, and acts as standard feeding.
     * i.e. increases animal health at no cost.<br>
     * 
     * To feed with a health item, call with Item as parameter
     * ({@link #feed(Item)})
	 */
    public void feed() {
    	this.health += 2;
    }
    
    /**
     * Updates object attributes consistent with feeding the animal with an item as a daily action.
	 * <p>
	 * This function takes one item, to be consumed.
     * i.e. increases animal health multiplied by item modifier ({@link Item#getMod()})<br>
     * 
     * To feed without a health item, call without Item as parameter
     * ({@link #feed()})
     * 
     * @param item FarmItem to use while feeding
     * @throws InvalidItemException if ({@link Item#getEffect()}) != "health"
     */
    public void feed(Item item) throws InvalidItemException {
    	if (item.getEffect().equals("health")) {
    		this.health += item.getMod() * 2;
    	} else {
    		throw new InvalidItemException();
    	} 
    }
	
    /**
     * Updates object attributes consistent with playing with the animal as a daily action
     * <p>
     * This function takes no parameters, and acts as standard playing.
     * i.e. increases animal mood at no cost.<br>
     * 
     * To play with a mood item, call with Item as parameter
     * ({@link #play(Item)})
     */
	public void play() {
		this.mood += 1 * Game.getFarm().getMod("happiness") ; //play with animals/pat
	}
	
    /**
     * Updates object attributes consistent with playing with the animal with an item as a daily action.
     * <p>
     * This function takes one item, to be consumed.
     * i.e. increases animal mood multiplied by item modifier ({@link Item#getMod()})<br>
     * 
     * To play without a mood item, call without Item as parameter
     * ({@link #play()})
     * @param item FarmItem to use while playing
     * @throws InvalidItemException if ({@link Item#getEffect()}) != "mood"
     */
	public void play(Item item) throws InvalidItemException {
    	if (item.getEffect().equals("mood")) {
    		mood += item.getMod() * 1 * Game.getFarm().getMod("happiness");
    	} else {
    		throw new InvalidItemException();
    	} 
	}
}
