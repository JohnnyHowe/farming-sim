package farmSim;
import java.util.Scanner;


/**
 * Game class - acts as game environment.
 * Runs game through console
 * Does not check whether input is valid as this is only for development purposes.
 */
public class ConsoleGame extends Game {

    private Scanner scanner;

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
        System.out.println(this.toString());
    }

    /**
     * Prints the end game string to the console.
     * String in the form "You ended the game with {points} points."
     * points is the returned value from the calculatePoints method.
     */
    private void end() {
        System.out.println("You ended the game with " + this.getPoints() + " points.");
        System.exit(0);
    }

    /**
     * runDay serves as the code inside the main game loop.
     */
    public void runDay() {
        int dayNum = this.getCurrentDay() + 1;  // + 1 so it starts at 1 - looks better
        System.out.println("\nWhat are you going to do today? (Day " + dayNum + ")");
        String input = this.scanner.nextLine();
        this.runInput(input);
    }

    /**
     * Given a string from the user input, run some command
     *
     * "end game" finishes the game, even if not all days are completed.
     *
     * @param userInput Input string
     */
    private void runInput(String userInput) {
        switch(userInput.toLowerCase()) {
            case "help":
                // I am well aware this is not the best way to do this but that's okay
                // This won't be in the final build
                System.out.println("Commands:\nend game\nend day\nview farm name\n" +
                        "view farmer name\nview game length");
                break;
            case "end game":
                System.exit(0);
                break;
            case "end day":
                this.increaseDayCounter();
                break;
            case "view farm name":
                System.out.println(this.farm.getName());
                break;
            case "view farmer name":
                System.out.println(this.farmer.getName());
                break;
            case "view game length":
                System.out.println(this.getGameLength() + " days");
                break;
            default:
                System.out.println("Unknown action: " + userInput);
        }
    }

    public static void main(String[] args) {
        ConsoleGame game = new ConsoleGame();
        game.run();
    }
}
