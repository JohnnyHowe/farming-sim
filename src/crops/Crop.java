package crops;

import farmSim.FarmItem;
import farmSim.Game;
import items.Item;

/**
 * Class for representing a Crop
 * @author Alex Burling(arb142), Jonathon Howe(joh29)
 */
public class Crop extends FarmItem {
	
    private float grown;
    private float income;
    
    /**
     * Constructs the crop object with the:
     * crop name - i.e. type
     */
    public Crop (String name, String description, float price, float income) {
    	super(name, description, price);
    	this.income = income;
    	this.grown = 0;
    }
    
    /**
     * Handles end of the day actions
     * i.e. growth of crops
     */
    public void endDay() {
    	this.grown += 1 * Game.farm.growthMod; //natural daily growth
    }
    
    /**
     * Handles a harvest action, removes the item from the farm
     * and gives the farmer money proportional to it's growth
     */
    public void harvest() {
    	Game.farm.removeFarmItem(this);
    	Game.farmer.addMoney((float) (income * (grown * 0.1)));
    }
    
    /*
     * Handles tending the plant as a daily action
     * Overloaded function signature, call as
     * tend(Item item) to tend with an item
     */
    public void tend() {
    	this.grown += 1 * Game.farm.growthMod;	//tended with water
    }
    
    /*
     * Handles tending the plant as a daily action
     * Overloaded function signature, call as
     * tend() to tend with water (no item)
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
