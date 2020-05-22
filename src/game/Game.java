package game;

import animals.Animal;
import crops.Crop;
import exceptions.InvalidActionException;
import exceptions.InvalidItemException;
import exceptions.OutOfActionsException;
import farm.Farm;
import farm.FarmItem;
import farm.Farmer;
import farm.Store;
import items.Item;

/**
 * Game class - acts as game environment.
 * This is the file to run when the game is to be played.
 */
public abstract class Game {
	public static Farm farm;
    public static Farmer farmer;
    public static Store store;
    
    public enum Actions { CROP_STATUS, ANIMAL_STATUS, FARM_STATUS,
    					VISIT_STORE, END_DAY, TEND_CROPS,
    					FEED_ANIMALS, PLAY_ANIMALS, HARVEST_CROPS, 
    					TEND_FARM} //Player's Action set

    private int gameLength;     // How many days the game will last
    private static int currentDay;     // Current game day

    // ==================================================
    // Interface method declarations
    // ==================================================

    /**
     * Called once before the game loop
     */
    public void setUp() {
        Game.currentDay = 0;
        Game.store = new Store();
    }
    
    public void endGame() {
    	
    }

    /**
     * The method called once each game loop
     */
    public abstract void runDay();

    // ==================================================
    // Basic getters and setters
    // ==================================================

    /**
     * Given a number of days, set the max game length.
     *
     * @param gameLength Number of days game will last.
     */
    public void setGameLength(int gameLength) {
        this.gameLength = gameLength;
    }

    /**
     * Gets the current day (first day is day 0)
     * @return currentDay
     */
    public int getCurrentDay() {
        return Game.currentDay;
    }

    /**
     * Increase the day counter by one.
     */
    public static void increaseDayCounter() {
        currentDay += 1;
    }

    /**
     * Get the game length (in days)
     * @return gameLength
     */
    public int getGameLength() {
        return this.gameLength;
    }

    /**
     * Returns the points the player has earned.
     *
     * @return points
     */
    public int getPoints() {
        return 69420;
    }

    // ==================================================
    // Other
    // ==================================================

    /**
     * Gets the string representation of the game.
     * in form "Game with farmer {farmer name} on farm {farm name}."
     */
    public String toString() {
        return "Game with farmer " + Game.farmer.getName() + " on farm " + Game.farm.getName() + ".";
    }

    public void run() {
        this.setUp();
        while (this.getCurrentDay() < this.getGameLength()) {
            this.runDay();
            //action = recieveAction
            //actionHandler.handle(action);
            //TODO add OutOfActions exception handler
            //TODO add InvalidAction exception handler
        }
        this.endGame();
        
    }

    /**
	 * While this would normally be abstract, abstract and static dont work so well.
	 * And unfortunately you can not override static methods in Java. This is however
	 * method hiding, and because Game is abstract, there will never be an instance of this method.
	 * This exists to let actionHandler work properly, and is implemented in Game subclasses
	 * (i.e. ConsoleGame, GUIGame)
	 */
	protected static void visitStore() {
		;
	}
	
	
	
}

/**
 * Action Handler class
 * Exists to simplify game loop and handle behind scenes computation
 * for player actions
 * This is the file to run when the game is to be played.
 * 
 */
abstract class actionHandler {
	
	/**
	 * Handles all of the actions a player can take
	 * Overloaded function signature, call as
     * handle(String action, Item consume) to handle player actions that consume
     * an Item
	 * @param action String represents player's action
	 * @throws OutOfActionsException 
	 * @throws InvalidActionException 
	 */
	public void handle(Game.Actions action) throws OutOfActionsException, InvalidActionException {
		switch (action) {
		case CROP_STATUS:	//View the status of the farm’s crops
			break;
		case ANIMAL_STATUS: //View the status of the farm’s animals
			break;
		case FARM_STATUS: //View the status of the farm including inventory
			break;
		case VISIT_STORE: //View the store
			Game.visitStore();
			break;
		case END_DAY: //End the game day
			Game.farmer.resetActions();
			Game.increaseDayCounter();
			for (FarmItem item : Game.farm.getFarmItems()) {
				item.endDay();
			}
			break;
		case TEND_CROPS: //Tend to the crops
			if (Game.farmer.canWork()) {
				for (FarmItem item : Game.farm.getFarmItems()) {
					if (item instanceof Crop);
						((Crop) item).tend();
				}
			} else {
				throw new OutOfActionsException();
			}
			break;
		case FEED_ANIMALS: //Feed the animals
			if (Game.farmer.canWork()) {
				for (FarmItem item : Game.farm.getFarmItems()) {
					if (item instanceof Animal);
						((Animal) item).feed();
				}
			} else {
				throw new OutOfActionsException();
			}
			break;
		case PLAY_ANIMALS: //Play with the animals
			if (Game.farmer.canWork()) {
				for (FarmItem item : Game.farm.getFarmItems()) {
					if (item instanceof Animal);
						((Animal) item).play();
				}
			} else {
				throw new OutOfActionsException();
			}
			break;
		case HARVEST_CROPS: //Harvest crops
			if (Game.farmer.canWork()) {
				for (FarmItem item : Game.farm.getFarmItems()) {
					if (item instanceof Crop);
						((Crop) item).harvest();
				}
			} else {
				throw new OutOfActionsException();
			}
			break;
		case TEND_FARM: //Tend to the farmland (cleanliness)
			if (Game.farmer.canWork()) {
				Game.farm.cleanUp();
			} else {
				throw new OutOfActionsException();
			}
			break;
		default:
			throw new InvalidActionException();
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
			if (Game.farmer.canWork()) {
				for (FarmItem item : Game.farm.getFarmItems()) {
					if (item instanceof Crop);
						((Crop) item).tend(consume);
				}
			} else {
				throw new OutOfActionsException();
			}
			break;
		case FEED_ANIMALS: //Feed the animals with consumable
			if (Game.farmer.canWork()) {
				for (FarmItem item : Game.farm.getFarmItems()) {
					if (item instanceof Animal);
						((Animal) item).feed(consume);
				}
			} else {
				throw new OutOfActionsException();
			}
			break;
		case PLAY_ANIMALS: //Play with the animals with consumable
			if (Game.farmer.canWork()) {
				for (FarmItem item : Game.farm.getFarmItems()) {
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