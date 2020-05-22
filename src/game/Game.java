package game;

import animals.Animal;
import crops.Crop;
import exceptions.InvalidActionException;
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
	 * Abstract method definition to handle different store display methods.
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
	public void handle(String action) throws OutOfActionsException, InvalidActionException {
		switch (action) {
		case "statusCrops":	//View the status of the farm’s crops
			break;
		case "statusAnimals": //View the status of the farm’s animals
			break;
		case "statusFarm": //View the status of the farm including inventory
			break;
		case "goStore": //View the store
			Game.visitStore();
			break;
		case "endDay": //End the game day
			Game.farmer.resetActions();
			Game.increaseDayCounter();
			for (FarmItem item : Game.farm.getFarmItems()) {
				item.endDay();
			}
			break;
		case "tendCrops": //Tend to the crops
			if (Game.farmer.canWork()) {
				for (FarmItem item : Game.farm.getFarmItems()) {
					if (item instanceof Crop);
						((Crop) item).tend();
				}
			} else {
				throw new OutOfActionsException();
			}
			break;
		case "feed": //Feed the animals
			if (Game.farmer.canWork()) {
				for (FarmItem item : Game.farm.getFarmItems()) {
					if (item instanceof Animal);
						((Animal) item).feed();
				}
			} else {
				throw new OutOfActionsException();
			}
			break;
		case "play": //Play with the animals
			if (Game.farmer.canWork()) {
				for (FarmItem item : Game.farm.getFarmItems()) {
					if (item instanceof Animal);
						((Animal) item).play();
				}
			} else {
				throw new OutOfActionsException();
			}
			break;
		case "harvest": //Harvest crops
			if (Game.farmer.canWork()) {
				for (FarmItem item : Game.farm.getFarmItems()) {
					if (item instanceof Crop);
						((Crop) item).harvest();
				}
			} else {
				throw new OutOfActionsException();
			}
			break;
		case "tendFarm": //Tend to the farmland (cleanliness)
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
		
	
	public static void handle(String action, Item consume) {
		switch (action) {
		case "tendCrops": //Tend to the crops
			for (FarmItem item : Game.farm.getFarmItems()) {
				if (item instanceof Crop);
				((Crop) item).tend();
				item.endDay();
			}
			break;
		case "feed": //Feed the animals
			break;
		case "play": //Play with the animals
			break;
		}
	//TODO Implement
	}
}