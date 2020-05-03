import java.util.Scanner;


/**
 * Game class - acts as game environment.
 * This is the file to run when the game is to be played.
 */
public class Game {
    public Farm farm;
    public Farmer farmer;

    private int gameLength;     // How many days the game will last
    private int currentDay;     // Current game day

    /**
     * Initialize the game.
     * Sets currentDay to zero.
     */
    public Game() {
        this.currentDay = 0;
    }

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
     * in form "Generic game with farmer {farmer name} on farm {farm name}."
     */
    public String toString() {
        return "Generic game with farmer " + this.farmer.getName() + " on farm " + this.farm.getName() + ".";
    }
}

