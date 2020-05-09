package crops;

import farmSim.FarmItem;
import farmSim.Game;
import items.Item;

public class Crop extends FarmItem {
	
    private double grown = 0;
    private double income;
    private double threshold;
    
    public Crop (String name, String description, double price, double income, double threshold) {
    	super(name, description, price);
    	this.income = income;
    	this.threshold = threshold;
    }
    
    /*
     * Handles end of the day actions
     * i.e. growth of crops
     */
    public void endDay() {
    	this.grown += 1 * Game.farm.growthMod; //natural daily growth
    }
    
    public void harvest() {
    	//remove from farm's list of crops
    	Game.farmer.addMoney(income);
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
    		//delete item from players inventory
    	} else {
    		System.out.println("That item cant be used on crops!");
    	}
    	
    }
    
    public boolean isGrown() {
    	return (grown >= threshold);
    }
}
