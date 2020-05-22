package farm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;

import animals.Animal;
import crops.Crop;
import items.Item;

/**
 * Class to represent the store.
 * has methods to buy crops and animals
 */
public class Store {
	
    private Dictionary<String, Crop> crops;
    private Dictionary<String, Item> items;
    private Dictionary<String, Animal> animals;


    /**
     * Populate the store's stock to contain one of each game item
     */
    public Store() {
        this.crops = ItemFactory.GetAllCrops();
        this.items = ItemFactory.GetAllItems();
        this.animals = ItemFactory.GetAllAnimals();
    }

    /**
     * Get the arrayList of crop names
     * @return crops
     */
    public ArrayList<String> getCropNames() {
        return Collections.list(this.crops.keys());
    }

    /**
     * Get the arrayList of crops names (all in lower case)
     * @return crops
     */
    public ArrayList<String> getCropNamesLowerCase() {
        ArrayList<String> names = new ArrayList<String>();
        for (String name : this.getCropNames()) {
            names.add(name.toLowerCase());
        }
        return names;
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

    /**
     * Given the name of a farm item, return an instance of it.
     * Unlike the factory this does not create a new object, only references
     * the stored one. If the name is invalid, a message is printed to the console
     * and null is returned.
     * Use only for simple item info.
     * @param name name of item
     * @return FarmItem item requested
     */
    public FarmItem getFarmItemInfo(String name) {
        FarmItem itemObj = null;    // = null to keep ide happy

        // Two of these will be null (3 if the name is invalid)
        FarmItem crop = this.crops.get(name);
        FarmItem animal = this.animals.get(name);
        FarmItem item = this.items.get(name);

        // Check for what one is valid
        if (crop != null) {
            itemObj = crop;
        } else if (animal != null) {
            itemObj = animal;
        } else if (item != null) {
            itemObj = item;
        }
        return itemObj;
    }

    /**
     * To be called when the farmer requests to buy something.
     * If the player doesn't have enough money, a message is displayed to the console
     * @param farmer Farmer requesting to buy item
     * @param farm Farm to send item to
     * @param itemName Name of FarmItem to buy
     * @return Whether the purchase was successful
     */
    public boolean buy(Farmer farmer, Farm farm, String itemName) {
        FarmItem item = this.getFarmItemInfo(itemName);
        if (farmer.hasFunds(item.getBuyPrice())) {
            farmer.spendMoney(item.getBuyPrice());
            // Send item to farm inventory
            System.out.println("ITEM NOT SENT TO FARM INVENTORY - CODE NOT IN YET");
        } else {
            System.out.println("Insufficient funds for item " + itemName);
        }

        return false;
    }
}
