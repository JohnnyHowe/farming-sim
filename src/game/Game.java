package game;

import farm.Farm;
import farm.Farmer;
import farm.Store;

/**
 * Game class - acts as game environment.
 * This is the file to run when the game is to be played.
 */
public abstract class Game {
	
	protected static Farm farm;
    protected static Farmer farmer;
    protected static Store store;
    protected static Game gameInstance;
    
    public enum Actions {VISIT_STORE, END_DAY, TEND_CROPS,
    					FEED_ANIMALS, PLAY_ANIMALS, HARVEST_CROPS, 
    					TEND_FARM, GAME_INFO, END_GAME, HELP} //Player's Action set

    protected static int gameLength;     // How many days the game will last
    protected static int currentDay = 0;     // Current game day
    

    public Game(int length) {
    	gameLength = length;
    }
    
    public static Game getInstance() {
    	return gameInstance;
    }
    
    public static Store getStore() {
    	if (store == null) {
    		store = new Store();
    	}
    	return store;
    }
    
    public static Farm getFarm() {
    	if (farm == null) {
    		farm = new Farm();
    	}
    	return farm;
    }
    
    public static Farmer getFarmer() {
    	if (farmer == null) {
    		farmer = new Farmer();
    	}
    	return farmer;
    }

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
     * Given a number of days, set the max game length.
     *
     * @param gameLength Number of days game will last.
     */
    public void setGameLength(int gameLength) {
        Game.gameLength = gameLength;
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
    public void increaseDayCounter() {
        Game.currentDay += 1;
    }

    /**
     * Get the game length (in days)
     * @return gameLength
     */
    public int getGameLength() {
        return gameLength;
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
        while (Game.getInstance().getCurrentDay() < Game.getInstance().getGameLength()) {
            this.runDay();
            //action = recieveAction
            //actionHandler.handle(action);
            //TODO add OutOfActions exception handler
            //TODO add InvalidAction exception handler
        }
        this.endGame();
        
    }
    

    protected abstract void runDay();

	protected abstract void visitStore();

	protected abstract void end();

	protected abstract void displayHelp();

}