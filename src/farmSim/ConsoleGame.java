package farmSim;
import java.util.Scanner;
import crops.Crop;


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
     * Show the available store items
     */
    private void viewStore() {
        System.out.println("Crops:");
        for (String name : this.store.getCropNames()) {
            Crop crop = this.store.getCrop(name);
            System.out.println(crop.getName() + " ($" + crop.getBuyPrice() + ")");
        }
    }

    /**
     * Ask the user what they want to buy
     */
    private void buyItem() {
        boolean done = false;
        String item = "";

        while (!done) {
            System.out.println("What would you like to buy?");
            item = this.scanner.nextLine().toLowerCase();

            if (this.store.getCropNames().contains(item) || item.equals("nothing")) {
                done = true;
            } else {
                System.out.println("Unknown item: " + item);
                System.out.println("Try an item from the following: " + this.store.getCropNames());
            }
        }
        System.out.println("Bought " + item);
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
            case "view farm":
                break;
            case "view farmer name":
                System.out.println(this.farmer.getName());
                break;
            case "view game length":
                System.out.println(this.getGameLength() + " days");
                break;
            case "visit store":
                this.visitStore();
                break;
            default:
                System.out.println("Unknown action: " + userInput);
        }
    }

    public void viewFarm() {
        System.out.println(this.farm.toString());

    }

    public void visitStore() {
        while(true) {   // Yeah i know its bad to idc
            System.out.println("What would you like to do at the store?");
            String item = this.scanner.nextLine().toLowerCase();
            switch (item) {
                case "leave":
                    return;
                case "view items":
                    this.viewStore();
                    return;
                case "buy":
                    this.buyItem();
                    return;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }

    public static void main(String[] args) {
        ConsoleGame game = new ConsoleGame();
        game.run();
    }
}
