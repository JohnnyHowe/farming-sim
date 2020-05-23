package farm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;

import animals.Animal;
import crops.Crop;
import exceptions.InsufficientFundsException;
import farm.FarmItem.FarmItems;
import items.Item;

/**
 * Class to represent the store.
 * has methods to buy crops and animals
 */
public class Store {
	
    private Dictionary<FarmItems, Crop> crops;
    private Dictionary<FarmItems, Item> items;
    private Dictionary<FarmItems, Animal> animals;


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
    public ArrayList<FarmItems> getCropNames() {
        return Collections.list(this.crops.keys());
    }
    
    /**
     * Get the arrayList of items
     * @return items
     */
    public ArrayList<FarmItems> getItemNames() {
    	return Collections.list(this.items.keys());
    }
    
    /**
     * Get the arrayList of animals
     * @return animals
     */
    public ArrayList<FarmItems> getAnimalNames() {
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

    /**
     * Given the name of a farm item, return an instance of it.
     * Unlike the factory this does not create a new object, only references
     * the stored one. If the name is invalid, a message is printed to the console
     * and null is returned.
     * Use only for simple item info.
     * @param name name of item
     * @return FarmItem item requested
     */
    public FarmItem getFarmItemInfo(String name) {// i assume this is for display, why not just refer to the dictionary with an index and increase the index
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
     * @param farmer Farmer requesting to buy item
     * @param farm Farm to send item to
     * @param itemName Name of FarmItem to buy
     * @return Whether the purchase was successful
     * @throws InsufficientFundsException 
     */
    public boolean buy(Farmer farmer, Farm farm, String itemName) throws InsufficientFundsException {
        FarmItem item = this.getFarmItemInfo(itemName);
        if (farmer.hasFunds(item.getBuyPrice())) {
            farmer.spendMoney(item.getBuyPrice());
            //Game.getFarm().addFarmItem(ItemFactory.GetNew(itemName));
        } else {
            throw new InsufficientFundsException();
        }

        return false;
    }
}
