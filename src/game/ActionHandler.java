package game;

import animals.Animal;
import crops.Crop;
import exceptions.InvalidActionException;
import exceptions.InvalidItemException;
import exceptions.OutOfActionsException;
import farm.FarmItem;
import farm.FarmItem.FarmItems;
import items.Item;

/**
 * Action Handler class
 * Exists to simplify game loop and handle behind scenes computation
 * for player actions
 * @author Alex Burling(arb142)
 */
public abstract class ActionHandler {
	
	/**
	 * Handles all of the actions a player can take
	 * Overloaded function signature, call as
     * handle(String action, Item consume) to handle player actions that consume
     * an Item
	 * @param action String represents player's action
	 * @throws OutOfActionsException 
	 */
	public static void handle(Game.Actions action) throws OutOfActionsException {
		switch (action) {
		
			case END_GAME: endGame(); break;
				
			case HELP: help(); break;
				
			case VISIT_STORE: Game.getInstance().setAtStore(true); break;
				
			case END_DAY: endDay(); break;
				
			case HARVEST_CROPS: harvestCrops(); break;
				
			case TEND_FARM: tendFarm(); break;
	
			default: break;
		}
	}
	
	public static void handle(Game.Actions action, FarmItem instance) throws OutOfActionsException, InvalidActionException {
		switch (action) {
			case TEND_CROPS: tendCrops((Crop) instance); break;

			case FEED_ANIMALS: feedAnimals((Animal) instance); break;
	
			case PLAY_ANIMALS: playAnimals((Animal) instance); break;
			
			default: break;
		}
	}
		
	/**
	 * Handles all of the actions a player can take that would consume an item.
	 * Overloaded function signature, call as
     * handle(String action) to handle player actions that don't consume an item.
	 * @param action String represents player's action
	 * @param consume FarmItem FarmItem to be consumed with action
	 * @throws OutOfActionsException
	 * @throws InvalidActionException
	 * @throws InvalidItemException
	 */
	public static void handle(Game.Actions action, FarmItem instance, FarmItems consumeEnum) throws OutOfActionsException, InvalidActionException, InvalidItemException {
		Item consume = (Item) Game.getFarm().getItem(consumeEnum);
		switch (action) {
		case TEND_CROPS: tendCropsItem((Crop) instance, consume); break;
		
		case FEED_ANIMALS: feedAnimalsItem((Animal) instance, consume); break;
		
		case PLAY_ANIMALS: playAnimalsItem((Animal) instance, consume); break;
		
		default: break;
		}
	}
	
	public static void storeHandle(Game.StoreActions action) {
		switch (action) {
			case VIEW_STOCK: viewStock(); break;
			case HELP: Game.getStore().displayStoreHelp(); break;
			case LEAVE: Game.getInstance().setAtStore(false); break;
			default: break;
		}
	}

	private static void viewStock() {
		System.out.println("\nAvailable Crops:");
		for (Crop crop: Game.getStore().getCrops()) {
			System.out.print(crop.getName() + " | ");
		}
		System.out.println("\n\nAvailable Animals:");
		for (Animal animal: Game.getStore().getAnimals()) {
			System.out.print(animal.getName() + " | ");
		}
		System.out.println("\n\nAvailable Consumables:");
		for (Item item: Game.getStore().getItems()) {
			System.out.print(item.getName() + " | ");
		}
		System.out.println();
	}

	private static void endGame() {
		Game.getInstance().endGame();
	}
	
	private static void help() {
		Game.getInstance().displayHelp();
	}
	
	private static void endDay() {
		Game.getFarmer().resetActions();
		Game.getInstance().increaseDayCounter();
		Game.getFarm().endDay();
		for (FarmItem item : Game.getFarm().getPaddockItems()) {
			item.endDay();
		}
	}
	
	private static void tendCrops(Crop cropInstance) throws OutOfActionsException {
		if (Game.getFarmer().canWork()) {
			for (FarmItem item : Game.getFarm().getPaddockItems()) {
				if (item.getClass().equals(cropInstance.getClass())) {
					((Crop) item).tend();
				}
			}
			Game.getFarmer().work();
		} else {
			throw new OutOfActionsException();
		}
	}
	
	private static void tendCropsItem(Crop cropInstance, Item consume) throws InvalidItemException, OutOfActionsException {
		if (Game.getFarmer().canWork()) {
			for (FarmItem item : Game.getFarm().getPaddockItems()) {
				if (item.getClass().equals(cropInstance.getClass())) {
					((Crop) item).tend(consume);
				}
			}
			Game.getFarmer().work();
    		Game.getFarm().removeFarmItem(consume);
		} else {
			throw new OutOfActionsException();
		}
	}
	
	private static void feedAnimals(Animal animalInstance) throws OutOfActionsException {
		if (Game.getFarmer().canWork()) {
			for (FarmItem item : Game.getFarm().getPaddockItems()) {
				if (item.getClass().equals(animalInstance.getClass())) {
					((Animal) item).feed();
				}
			}
			Game.getFarmer().work();
		} else {
			throw new OutOfActionsException();
		}
	}
	
	private static void feedAnimalsItem(Animal animalInstance, Item consume) throws OutOfActionsException, InvalidItemException {
		if (Game.getFarmer().canWork()) {
			for (FarmItem item : Game.getFarm().getPaddockItems()) {
				if (item.getClass().equals(animalInstance.getClass())) {
					((Animal) item).feed(consume);
				}
			}
			Game.getFarmer().work();
			Game.getFarm().removeFarmItem(consume);
		} else {
			throw new OutOfActionsException();
		}
	}
	
	private static void playAnimals(Animal animalInstance) throws OutOfActionsException {
		if (Game.getFarmer().canWork()) {
			for (FarmItem item : Game.getFarm().getPaddockItems()) {
				if (item.getClass().equals(animalInstance.getClass())) {
					((Animal) item).play();
				}
			}
			Game.getFarmer().work();
		} else {
			throw new OutOfActionsException();
		}
	}
	
	private static void playAnimalsItem(Animal animalInstance, Item consume) throws InvalidItemException, OutOfActionsException {
		if (Game.getFarmer().canWork()) {
			for (FarmItem item : Game.getFarm().getPaddockItems()) {
				if (item.getClass().equals(animalInstance.getClass())) {
					((Animal) item).play(consume);
				}
			}
			Game.getFarmer().work();
			Game.getFarm().removeFarmItem(consume);
		} else {
			throw new OutOfActionsException();
		}
	}
	
	private static void harvestCrops() throws OutOfActionsException {
		if (Game.getFarmer().canWork()) {
			for (FarmItem item : Game.getFarm().getPaddockItems()) {
				if (item instanceof Crop) {
					((Crop) item).harvest();
				}
			}
			Game.getFarmer().work();
		} else {
			throw new OutOfActionsException();
		}
	}
	
	private static void tendFarm() throws OutOfActionsException {
		if (Game.getFarmer().canWork()) {
			Game.getFarm().cleanUp();
			Game.getFarmer().work();
		} else {
			throw new OutOfActionsException();
		}
	}
}
