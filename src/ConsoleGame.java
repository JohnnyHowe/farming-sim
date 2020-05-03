import java.util.Scanner;

/**
 * Game class - acts as game environment.
 * Runs game through console
 * Does not check whether input is valid as this is only for development purposes.
 */
public class ConsoleGame extends Game {

    /**
     * Initialize the game
     */
    public ConsoleGame() {
        super();
    }

    /**
     * Set up the game
     * Creates Farm, Farmer
     */
    private void setUp() {
        Scanner in = new Scanner(System.in);
        System.out.println("How many days will the game last?: ");
        this.setGameLength(Integer.parseInt(in.nextLine()));
        System.out.println("Farm name: ");
        this.farm = new Farm(in.nextLine());
        System.out.println("Farmer name: ");
        this.farmer = new Farmer(in.nextLine());
        in.close();
    }

    /**
     * Prints the end game string to the console.
     * String in the form "You ended the game with {points} points."
     * points is the returned value from the calculatePoints method.
     */
    private void endGame() {
        System.out.println("You ended the game with " + this.getPoints() + " points.");
    }

    /**
     * runDay serves as the code inside the main game loop.
     */
    private void runDay() {
        // Get user input
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        in.close();
    }

    /**
     * Main game loop.
     *
     * @param args command line args, they do nothing
     */
    public static void main(String[] args) {
        ConsoleGame game = new ConsoleGame();
        game.setUp();

        // Game loop

        // end game
    }
}
