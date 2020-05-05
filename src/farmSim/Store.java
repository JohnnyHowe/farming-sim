package farmSim;
import java.util.ArrayList;

/**
 * Class to represent the store.
 * has methods to buy crops and animals
 */
public class Store {
	
	//private ArrayList<FarmItem> stock;
	//private final int STOCK_SPACE = 12;

    public Store() {
    	//generate stock
    }
    
    public void endDay() {
    	//if STOCK_SPACE < len(stock):
    	//generate more stock
    	
    	//alternatively and probably easiest just give the store a static front with no "stocklevels"
    	//i.e every item is always available to buy, for the same price, and is not affected by player
    }
    
    public void upgradeField() { //boosts crop growth
    	//farm upgrades to boost the farms growth, happiness and income mods?
    	//you replow and fertilise the field, crop growth is faster
    }

    public void upgradePaddock() { //boosts animal happiness
    	//farm upgrades to boost the farms growth, happiness and income mods?
    	//you reseed and refence the animal paddocks, animal happiness drops slower
    }
    
    public void upgradeStall() { //boosts income
    	//farm upgrades to boost the farms growth, happiness and income mods?
    	//you stepped up your advertising and market reach, global income is increased
    }

}
