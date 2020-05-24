package game;

import farm.Farm;
import farm.Farmer;
import farm.Store;
import game.guiGame.IntroScreen;


/**
 * Game class - acts as game environment structure. Built on a pseudo singleton structure,
 * handles the creation of each other singleton within the simulator.
 * Acts as a superclass to build logic off of for different i/o methods.
 * @author Alex Burling(arb142), Jonathon Howe(joh29)
 * @see ConsoleGame
 * @see IntroScreen
 */
public abstract class Game {
	
	private static Farm farm;
    private static Farmer farmer;
    private static Store store;
    private static Game gameInstance;

    private static int gameLength;     // How many days the game will last
    private static int currentDay = 0;     // Current game day
    
    /**
     * Public enum to handle player actions.
     * Contains all possible player actions.
     */
    public enum Actions {VISIT_STORE, END_DAY, TEND_CROPS,
    					FEED_ANIMALS, PLAY_ANIMALS, HARVEST_CROPS, 
    					TEND_FARM, GAME_INFO, END_GAME, HELP} 

    /**
     * Public enum to handle player actions at the store.
     * Contains all possible store actions.
     */
    public enum StoreActions {VIEW_STOCK, BUY, SELL, LEAVE}
    
   
    /*=============================
     * SINGLETON STATIC RETRIEVERS
     * ============================
     */
    
    /**
     * Constructor to initalise game singleton, and store self in static 
     * reference for later retrieval
     * @param length int Game length in days
     */
    public Game(int length) {
    	gameLength = length;
    	setInstance(this);
    }

    public static void setInstance(Game instance) {
        gameInstance = instance;
    }

    /**
     * Instance access function for singleton Game object.
     * Note, this will never be the Game class, always a subclass of Game.
     * @return Game Game instance
     * @see Game
     */
    public static Game getInstance() {
    	return gameInstance;
    }
    
    /**
     * Instance access function for singleton Store object.
     * If you do not have a store, one will be provided for you.
     * @return Store Store instance
     * @see Store
     */
    public static Store getStore() {
    	if (store == null) {
    		store = new Store();
    	}
    	return store;
    }
    
    /**
     * Instance access function for singleton Farm object.
     * If you do not have a farm, one will be provided for you.
     * @return Farm Farm instance
     * @see Farm
     */
    public static Farm getFarm() {
    	if (farm == null) {
    		farm = new Farm();
    	}
    	return farm;
    }
    
    /**
     * Instance access function for singleton Farmer object.
     * If you do not have a farmer, one will be provided for you.
     * @return Farmer Farmer instance
     * @see Farmer
     */
    public static Farmer getFarmer() {
    	if (farmer == null) {
    		farmer = new Farmer();
    	}
    	return farmer;
    }

    
    /*=============================
     * BASIC LOGIC GETS & SETS
     * ============================
     */
    
    /**
     * Gets the current day (first day is day 0)
     * @return currentDay int
     */
    public int getCurrentDay() {
        return Game.currentDay;
    }

    /**
     * Sets the game length
     * @param length game length in days
     */
    public void setGameLength(int length) {
        Game.gameLength = length;
    }

    /**
     * Increase the day counter by one.
     */
    public void increaseDayCounter() {
        Game.currentDay += 1;
    }

    /**
     * Get the game length
     * @return gameLength int Game length in days
     */
    public int getGameLength() {
        return gameLength;
    }

    /**
     * Calculates the player's score
     * @return points int Player score
     */
    public int getScore() {
    	//TODO calculate points from something
    	//could return total value of farm?
    	//could be end game fuction only, would harvest/sell all inventory (as its the end of the game) and return total cash?
        return 69420;
    }
    
    
    
    /*=============================
     * GAME LOOP FUNCS
     * ============================
     */
    
    /**
     * Initialises game loop
     */
    public void run() {
        while (Game.getInstance().getCurrentDay() < Game.getInstance().getGameLength()) {
            this.runDay();
        }
        this.endGame();
    }


    /**
     * Main game loop function
     */
    protected abstract void runDay();

    /**
     * Handles store events
     * i.e. enteres another loop until player is done in store
     */
	protected abstract void visitStore();
	
	/**
	 * Handles ending the game
	 */
	protected abstract void endGame();

    /**
     * Prints a string displaying all available commands to System.out
     */
	protected abstract void displayHelp();

}