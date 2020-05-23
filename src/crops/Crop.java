package crops;

import exceptions.InvalidItemException;
import farm.FarmItem;
import game.Game;
import items.Item;

/**
 * Class for representing a Crop.
 * Crops grow daily and can be harvested to receive income.
 * @author Alex Burling(arb142), Jonathon Howe(joh29)
 * @see Cactus
 * @see Melon
 * @see Mushroom
 * @see Pumpkin
 * @see SugarCane
 * @see Wheat
 */
public abstract class Crop extends FarmItem {
	

    private float grown;
    private float income;
    
    /**
     * Constructs the Crop from the FarmItem constructor and crop specific values (income, grown).
     * Grown is always initialized to 0 and as such is not a param.
     * @param name Crop name, used when viewing status of item e.g. Wheat, Melon
     * @param description Crop description, used when viewing status of item
     * @param price Crop price, used when buying or selling to store
     * @param income Crop income, used when crop is harvested
     */
    public Crop (String name, String description, float price, float income) {
    	super(name, description, price);
    	this.income = income;
    	this.grown = 0;
    }
    
    /**
     * Handles end of the day actions.
     * i.e. natural growth of crops.
     * Implements superclass abstract method 
     */
    public void endDay() {
    	this.grown += 1 * Game.getFarm().growthMod; //natural daily growth
    }
    
    /**
     * Handles a harvest action.
     * i.e removes the item from the farm
     * and gives the farmer money proportional to it's growth.
     */
    public void harvest() {
    	Game.getFarm().removeFarmItem(this);
    	Game.getFarmer().addMoney((float) (income * (grown * 0.1)));
    }
    
    /**
     * Handles tending the plant as a daily action
     * i.e. increases growth of crop.
     * Overloaded function signature, call as
     * tend(Item item) to tend with an item
     */
    public void tend() {
    	this.grown += 1 * Game.getFarm().growthMod;	//tended with water
    }
    
    /**
     * Handles tending the plant as a daily action
     * i.e. increases growth of crop.
     * Overloaded function signature, call as
     * tend() to tend with water (no item)
     * @param item FarmItem to use while tending, only accepts items with effect "growth"
     * @throws InvalidItemException 
     */
    public void tend(Item item) throws InvalidItemException {
    	if (item.getEffect().equals("growth")) {
    		this.grown += item.getMod() * Game.getFarm().growthMod; //tended with item
    		Game.getFarm().removeFarmItem(item);
    	} else {
    		throw new InvalidItemException();
    	}
    	
    }
}
