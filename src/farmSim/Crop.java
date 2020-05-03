package farmSim;

public abstract class Crop extends FarmItem {
	
    private double grown = 0;
    private double income;
    
    public Crop (String name, String description, double price, double income) {
    	super(name, description, price);
    	this.income = income;
    }
    
    public void endDay() {
    	this.grown = this.grown + (1 * Game.farm.growthMod);
    }
    
    public void harvest() {
    	//remove from farms list of crops
    	Game.farmer.addMoney(income);
    }
}
