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
abstract class ActionHandler {
	
	/**
	 * Handles all of the actions a player can take
	 * Overloaded function signature, call as
     * handle(String action, Item consume) to handle player actions that consume
     * an Item
	 * @param action String represents player's action
	 * @throws OutOfActionsException 
	 * @throws InvalidActionException 
	 */
	public static void handle(Game.Actions action) throws OutOfActionsException {
		switch (action) {
		
			case END_GAME:
				Game.getInstance().endGame();
				break;
				
			case HELP:
				Game.getInstance().displayHelp();
				break;
				
			case VISIT_STORE: //View the store
				Game.getInstance().visitStore();
				break;
				
			case END_DAY: //End the game day
				Game.getFarmer().resetActions();
				Game.getInstance().increaseDayCounter();
				for (FarmItem item : Game.getFarm().getPaddockItems()) {
					item.endDay();
				}
				break;
				
			case TEND_CROPS: //Tend to the crops
				if (Game.getFarmer().canWork()) {
					
					for (FarmItem item : Game.getFarm().getPaddockItems()) {
						if (item instanceof Crop) {
							((Crop) item).tend();
						}
					}
				} else {
					throw new OutOfActionsException();
				}
				break;
				
			case FEED_ANIMALS: //Feed the animals
				if (Game.getFarmer().canWork()) {
					for (FarmItem item : Game.getFarm().getPaddockItems()) {
						if (item instanceof Animal) {
							((Animal) item).feed();
						}
					}
				} else {
					throw new OutOfActionsException();
				}
				break;
				
			case PLAY_ANIMALS: //Play with the animals
				if (Game.getFarmer().canWork()) {
					for (FarmItem item : Game.getFarm().getPaddockItems()) {
						if (item instanceof Animal) {
							((Animal) item).play();
						}
					}
				} else {
					throw new OutOfActionsException();
				}
				break;
				
			case HARVEST_CROPS: //Harvest crops
				if (Game.getFarmer().canWork()) {
					for (FarmItem item : Game.getFarm().getPaddockItems()) {
						if (item instanceof Crop) {
							((Crop) item).harvest();
						}
					}
				} else {
					throw new OutOfActionsException();
				}
				break;
				
			case TEND_FARM: //Tend to the farmland (cleanliness)
				if (Game.getFarmer().canWork()) {
					Game.getFarm().cleanUp();
					Game.getFarmer().work();
				} else {
					throw new OutOfActionsException();
				}
				break;
				
			default:
				break;
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
}
