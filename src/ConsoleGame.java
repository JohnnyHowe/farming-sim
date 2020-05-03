import java.util.Scanner;

/**
 * Game class - acts as game environment.
 * Runs game through console
 * Does not check whether input is valid as this is only for development purposes.
 */
public class ConsoleGame extends Game {

    Scanner scanner;

    /**
     * Initialize the game
     */
    public ConsoleGame() {
        super();
        this.scanner = new Scanner(System.in);
    }

    /**
     * Set up the game
     * Creates Farm, Farmer
     */
    public void setUp() {
//        Scanner in = new Scanner(System.in);
//        System.out.println("How many days will the game last?: ");
//        this.setGameLength(Integer.parseInt(in.nextLine()));
//        System.out.println("Farm name: ");
//        this.farm = new Farm(in.nextLine());
//        System.out.println("Farmer name: ");
//        this.farmer = new Farmer(in.nextLine());
//        in.close();

        // Couldn't be bothered typing it over and over again
        this.setGameLength(10);
        this.farm = new Farm("FarmName");
        this.farmer = new Farmer("FarmerName");

    }

    /**
     * Prints the end game string to the console.
     * String in the form "You ended the game with {points} points."
     * points is the returned value from the calculatePoints method.
     */
    private void end() {
        System.out.println("You ended the game with " + this.getPoints() + " points.");
    }

    /**
     * runDay serves as the code inside the main game loop.
     */
    public void runDay() {
        // Get user input
        System.out.println("What are you going to do today?");

//        Scanner in = new Scanner(System.in);
//        String input = "";
//        while (in.hasNext()) {
//            input = in.nextLine();
//        }
//        in.close();

        String input = this.scanner.nextLine();

        System.out.println("Run day doing: " + input + "\n");
    }

    public static void main(String[] args) {
        ConsoleGame game = new ConsoleGame();
        game.run();
    }
}
