package crops;

import farmSim.FarmItem;
import farmSim.Game;
import items.Item;

/**
 * Class for representing a Crop.
 * @author Alex Burling(arb142), Jonathon Howe(joh29)
 */
public class Crop extends FarmItem {
	

    private float grown;
    private float income;
    
    /**
     * Constructs the Crop from the FarmItem constructor and crop specific values (income, grown).
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
     */
    public void endDay() {
    	this.grown += 1 * Game.farm.growthMod; //natural daily growth
    }
    
    /**
     * Handles a harvest action.
     * i.e removes the item from the farm
     * and gives the farmer money proportional to it's growth.
     */
    public void harvest() {
    	Game.farm.removeFarmItem(this);
    	Game.farmer.addMoney((float) (income * (grown * 0.1)));
    }
    
    /**
     * Handles tending the plant as a daily action
     * i.e. increases growth of crop.
     * Overloaded function signature, call as
     * tend(Item item) to tend with an item
     */
    public void tend() {
    	this.grown += 1 * Game.farm.growthMod;	//tended with water
    }
    
    /**
     * Handles tending the plant as a daily action
     * i.e. increases growth of crop.
     * Overloaded function signature, call as
     * tend() to tend with water (no item)
     * @param item FarmItem to use while tending, only accepts items with effect "growth"
     */
    public void tend(Item item) {
    	if (item.getEffect().equals("growth")) {
    		this.grown += item.getMod() * Game.farm.growthMod; //tended with item
    		Game.farm.removeFarmItem(item);
    	} else {
    		System.out.println("That item cant be used on crops!");
    	}
    	
    }
}
