package crops;
import farmSim.FarmItem;
import farmSim.Game;


/**
 * Class representing a crop
 * Acts as parent for all other crops
 */
public abstract class Crop extends FarmItem {
	
    private double grow = 0;
    private double income;

    public Crop() {
        super();
    }

//    public Crop (String name, String description, double price, double income) {
//    	super(name, description, price);
//    	this.income = income;
//    }
    
    public void endDay() {
    	this.grown = this.grown + (1 * Game.farm.growthMod);
    }
    
    public void harvest() {
    	//remove from farm's list of crops
    	Game.farmer.addMoney(income);
    }
    
    /*public void tend(Item item) {                        //draft, waiting on item implementantion
    	this.grown += item.modifer * Game.farm.growthMod
    }
    */
}
