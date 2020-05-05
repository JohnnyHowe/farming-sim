package farmSim;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;

import crops.*;
import items.*;
import animals.*;

/**
 * Class to represent the store.
 * has methods to buy crops and animals
 */
public class Store {
	
    private Dictionary crops;
    private Dictionary items;
    private Dictionary animals;


    /**
     * Populate the store's stock to contain one of each game item
     */
    public Store() {
        this.crops = CropList.GetAllCrops();
        this.items = ItemList.GetAllItems();
        this.animals = AnimalList.GetAllAnimals();
    }


    /**
     * Get the arrayList of crops
     * @return crops
     */
    public ArrayList<String> getCropNames() {
        return Collections.list(this.crops.keys());
    }
    
    /**
     * Get the arrayList of items
     * @return items
     */
    public ArrayList<String> getItemNames() {
    	return Collections.list(this.items.keys());
    }
    
    /**
     * Get the arrayList of animals
     * @return animals
     */
    public ArrayList<String> getAnimalNames() {
    	return Collections.list(this.animals.keys());
    }

    /**
     * Given the name of the crop, return the object.
     * @param name name of crop
     * @return crop
     */
    public Crop getCrop(String name) {
        return (Crop) this.crops.get(name);
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
