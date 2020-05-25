package crops;

import exceptions.InvalidItemException;
import farm.FarmItem;
import game.Game;
import items.Item;

/**
 * Logic and structure superclass to construct different crops.
 * <p>
 * This class provides each crop with the logic and structure required, by
 * expanding on the FarmItem structure.<br>
 * Crops grow daily and can be harvested to receive income. Income is calculated
 * proportionally to crop growth ({@link #harvest}).
 * 
 * @version 1.0
 * @author Alex Burling(arb142)
 * @see Cactus
 * @see Melon
 * @see Mushroom
 * @see Pumpkin
 * @see SugarCane
 * @see Wheat
 */
public abstract class Crop extends FarmItem {
	
    private float grown;
	private int growTime;
	private float income;
    
    /**
     * Constructs the Crop from the FarmItem constructor and crop specific values 
     * (income, grown).
     * Grown is always initialized to 0 and as such is not a param.
     * @param name Crop name, used when viewing status of item e.g. Wheat, Melon
     * @param description Crop description, used when viewing status of item
     * @param price Crop price, used when buying or selling to store
     * @param income Crop income, used when crop is harvested
     */
    public Crop (String name, String description, float price, float income, FarmItems selfEnum, int growTime) {
    	super(name, description, price, selfEnum);
    	this.income = income;
    	this.grown = 0;
    	this.growTime = growTime;
    }

	/**
	 * How much has the crop grown?
	 * @return growth
	 */
	public float getGrowth() {
		return grown;
	}

	/**
	 * How many days will it take for the crop to grow?
	 * (if no multiplier)
	 * @return growTime
	 */
	public int getGrowTime() {
		return growTime;
	}
    
	/**
	 * Handles end of the day actions for Crop objects
	 * <p>
	 * Every FarmItem subclass must implement an endDay() function, to simplify game
	 * loop.
	 * 
	 * This is to handle crop specific logic and attributes.<br>
	 * i.e. natural plant growth<br>
	 */
    public void endDay() {
    	this.grown += 1 * Game.getFarm().getMod("growth"); //natural daily growth
        this.grown = Math.min(this.grown, this.growTime);
    }
    
    /**
     * Updates Farm inventory and Farmer cash consistent with harvesting and 
     * selling as a daily action
	 * <p>
     * i.e. removes crop from the farm and adds money proportional to it's growth.<br>
     */
    public void harvest() {
    	Game.getFarm().removeFarmItem(this);
    	Game.getFarmer().addMoney((float) (income * (grown * 0.1)));
    }
    
    /**
     * Updates object attributes consistent with tending the crop as a daily action
	 * <p>
     * This function takes no parameters, and acts as standard tending.
     * i.e. increases growth of crop at no cost.<br>
     * 
     * To tend with a growth item, call with Item as parameter
     * ({@link #tend(Item)})
     */
    public void tend() {
    	this.grown += 1 * Game.getFarm().getMod("growth");	//tended with water
    }
    
    /**
     * Updates object attributes consistent with tending the crop with an item
     *  as a daily action
	 * <p>
     * This function takes one item, to be consumed.
     * i.e. increases growth of crop multiplied by item modifier ({@link Item#getMod()})<br>
     * 
     * To play without a growth item, call without Item as parameter ({@link #play()})
     * @param item FarmItem to use while playing
     * @throws InvalidItemException if ({@link Item#getEffect()}) != "growth"
     */
    public void tend(Item item) throws InvalidItemException {
    	if (item.getEffect().equals("growth")) {
    		this.grown += item.getMod() * Game.getFarm().getMod("growth");
    		Game.getFarm().removeFarmItem(item);
    	} else {
    		throw new InvalidItemException();
    	}
    	
    }
}
