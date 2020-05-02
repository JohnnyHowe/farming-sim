import java.util.Scanner;


/**
 * Game class - acts as game environment.
 * This is the file to run when the game is to be played.
 */
public class Game
{
    private Farm farm;
    private Farmer farmer;

    /**
     * Initalize the game
     */
    public Game()
    {
        this.setUpFromConsole();
    }

    /**
     * Set up the game, taking input from the console
     * Creates Farm, Farmer
     * DOES NOT CHECK WHETHER INPUT IS VALID - JUST ROLLS WITH IT
     */
    private void setUpFromConsole()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Farm name: ");
        this.farm = new Farm(in.nextLine());
        System.out.println("Farmer name: ");
        this.farmer = new Farmer(in.nextLine());
    }

    /**
     * Returns the points the player has earned.
     * @return points
     */
    private int getPoints()
    {
        return 69420;
    }

    /**
     * Prints the end game string to the console.
     * String in the form "You ended the game with {points} points."
     * points is the returned value from the calculatePoints method.
     */
    private void endGame()
    {
        System.out.println("You ended the game with " + getPoints() + " points.");
    }

    /**
     * Gets the string representation of the game.
     * in form "Game with farmer {farmer name} on farm {farm name}."
     */
    public String toString()
    {
        return "Game with farmer " + this.farmer.getName() + " on farm " + this.farm.getName() + ".";
    }

    /**
     * Main method.
     * Runs the game.
     * @param args
     */
    public static void main(String[] args)
    {
        Game game = new Game();
        System.out.println(game.toString());
    }
}

