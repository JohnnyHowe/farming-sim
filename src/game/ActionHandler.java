package game;

import animals.Animal;
import crops.Crop;
import exceptions.InvalidActionException;
import exceptions.InvalidItemException;
import exceptions.OutOfActionsException;
import farm.FarmItem;
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
				
			case VISIT_STORE: Game.getInstance().atStore(true); break;
				
			case END_DAY: endDay(); break;
				
			case TEND_CROPS: tendCrops(); break;
				
			case FEED_ANIMALS: feedAnimals(); break;
				
			case PLAY_ANIMALS: playAnimals(); break;
				
			case HARVEST_CROPS: harvestCrops(); break;
				
			case TEND_FARM: tendFarm(); break;
	
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
	public static void handle(Game.Actions action, Item consume) throws OutOfActionsException, InvalidActionException, InvalidItemException {

		switch (action) {
		case TEND_CROPS: //Tend to the crops with consumable
			if (Game.getFarmer().canWork()) {
				for (FarmItem item : Game.getFarm().getPaddockItems()) {
					if (item instanceof Crop);
						((Crop) item).tend(consume);
				}
			} else {
				throw new OutOfActionsException();
			}
			break;
		case FEED_ANIMALS: //Feed the animals with consumable
			if (Game.getFarmer().canWork()) {
				for (FarmItem item : Game.getFarm().getPaddockItems()) {
					if (item instanceof Animal);
						((Animal) item).feed(consume);
				}
			} else {
				throw new OutOfActionsException();
			}
			break;
		case PLAY_ANIMALS: //Play with the animals with consumable
			if (Game.getFarmer().canWork()) {
				for (FarmItem item : Game.getFarm().getPaddockItems()) {
					if (item instanceof Animal);
						((Animal) item).play(consume);
				}
			} else {
				throw new OutOfActionsException();
			}
			break;
		default:
				throw new InvalidActionException();
		}
	}
	
	public static void storeHandle(Game.StoreActions action) {
		switch (action) {
			case VIEW_STOCK: viewStock(); break;
			case BUY: buy(); break;
			case SELL: sell(); break;
			case HELP: Game.getStore().displayStoreHelp(); break;
			case LEAVE: Game.getInstance().atStore(false); break;
			default: break;
		}
	}

	private static void helpStore() {
		// TODO Auto-generated method stub
		
	}

	private static void sell() {
		// TODO Auto-generated method stub
		
	}

	private static void buy() {
		// TODO Auto-generated method stub
		
	}

	private static void viewStock() {
		// TODO Auto-generated method stub
		
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
	
	private static void tendCrops() throws OutOfActionsException {
		if (Game.getFarmer().canWork()) {
			
			for (FarmItem item : Game.getFarm().getPaddockItems()) {
				if (item instanceof Crop) {
					((Crop) item).tend();
				}
			}
			Game.getFarmer().work();
		} else {
			throw new OutOfActionsException();
		}
	}
	
	private static void feedAnimals() throws OutOfActionsException {
		if (Game.getFarmer().canWork()) {
			for (FarmItem item : Game.getFarm().getPaddockItems()) {
				if (item instanceof Animal) {
					((Animal) item).feed();
				}
			}
			Game.getFarmer().work();
		} else {
			throw new OutOfActionsException();
		}
	}
	
	private static void playAnimals() throws OutOfActionsException {
		if (Game.getFarmer().canWork()) {
			for (FarmItem item : Game.getFarm().getPaddockItems()) {
				if (item instanceof Animal) {
					((Animal) item).play();
				}
			}
			Game.getFarmer().work();
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
