package farm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;

import animals.Animal;
import crops.Crop;
import exceptions.InsufficientFundsException;
import exceptions.InvalidActionException;
import farm.FarmItem.FarmItems;
import game.ConsoleGame;
import game.Game;
import game.ActionHandler;
import game.Game.StoreActions;
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
     *
     * @return crops
     */
    public ArrayList<FarmItems> getCropNames() {
        return Collections.list(this.crops.keys());
    }

    /**
     * Get the arrayList of items
     *
     * @return items
     */
    public ArrayList<FarmItems> getItemNames() {
        return Collections.list(this.items.keys());
    }

    /**
     * Get the arrayList of animals
     *
     * @return animals
     */
    public ArrayList<FarmItems> getAnimalNames() {
        return Collections.list(this.animals.keys());
    }

    /**
     * To be called when the farmer requests to buy something.
     *
     * @param farmer   Farmer requesting to buy item
     * @param farm     Farm to send item to
     * @param itemName Name of FarmItem to buy
     * @return Whether the purchase was successful
     * @throws InsufficientFundsException
     */
    public void buy(FarmItem item) throws InsufficientFundsException {
        if (Game.getFarmer().hasFunds(item.getBuyPrice())) {
            Game.getFarmer().spendMoney(item.getBuyPrice());
            Game.getFarm().addFarmItem(ItemFactory.GetNew(item));
        } else {
            throw new InsufficientFundsException();
        }
    }

    /*
     * CONSOLE SPECIFIC STORE FUNCTIONS BELOW
     */

    public void handleInput() {
        while (Game.atStore) {

            String userIn = ConsoleGame.scanner.nextLine();
            Game.StoreActions input = StoreActions.HELP;

            try {
                input = storeInputParser(userIn);
            } catch (InvalidActionException e) {
                System.out.println("Unknown Command:" + e.getMessage());
            }
            ActionHandler.storeHandle(input);
        }
    }

    /**
     * @param userIn
     * @return
     * @throws InvalidActionException
     */
    public StoreActions storeInputParser(String userIn) throws InvalidActionException {
        switch (userIn.replace(" ", "").toLowerCase()) {
            case "viewstock":
                return StoreActions.VIEW_STOCK;

            case "buy":
                return StoreActions.BUY;

            case "sell":
                return StoreActions.SELL;

            case "leave":
                return StoreActions.LEAVE;

            case "help":
                return StoreActions.HELP;

            default:
                throw new InvalidActionException(userIn.replace(" ", "").toLowerCase());
        }
    }

    public void displayStoreHelp() {
        System.out.println("Store Commands:\nView Stock\t|Buy\t|Sell\nLeave");
    }
    
    /*
    private static void viewStore() {
    	
    	atStore = true;
        while(atStore) {
            System.out.println("What would you like to do at the store?");
            String userIn = ConsoleGame.scanner.nextLine();
        	Game.StoreActions input = StoreActions.HELP;
        	
        	try {
    			input = Game.getStore().storeInputParser(userIn);
    		} catch (InvalidActionException e) {
    			System.out.println("Unknown Command:" + e.getMessage());
    		}
    		ActionHandler.storeHandle(input);
            }
    	;
        System.out.println("Crops:");
        for (String name : Game.getStore().getCropNames()) {
            Crop crop = Game.getStore().getCrop(name);
            System.out.println(crop.getName() + " ($" + crop.getBuyPrice() + ")");
        }
    }

    private static void buyItem() {
    	;
        boolean done = false;
        String item = "";

        while (!done) {
            System.out.println("What would you like to buy?");
            item = ConsoleGame.scanner.nextLine().toLowerCase();

            if (Game.getStore().getCropNames().contains(item) || item.equals("nothing")) {
                done = true;
            } else {
                System.out.println("Unknown item: " + item);
                System.out.println("Try an item from the following: " + Game.getStore().getCropNames());
            }
        }
        System.out.println("Bought " + item);
      
      
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
    }*/
}
