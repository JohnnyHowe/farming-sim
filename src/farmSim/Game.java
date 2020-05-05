package farmSim;

/**
 * Game class - acts as game environment.
 * This is the file to run when the game is to be played.
 */
public abstract class Game {
	public static Farm farm;
    public static Farmer farmer;
    public static Store store;

    private int gameLength;     // How many days the game will last
    private int currentDay;     // Current game day

    /**
     * Initialize the game.
     * Sets currentDay to zero.
     */
    public Game() {
        this.currentDay = 0;
        this.store = new farmSim.Store();
    }

    // ==================================================
    // Interface method declarations
    // ==================================================

    /**
     * Called once before the game loop
     */
    public abstract void setUp();

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
        return this.currentDay;
    }

    /**
     * Increase the day counter by one.
     */
    public void increaseDayCounter() {
        this.currentDay += 1;
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
        }
    }
}

