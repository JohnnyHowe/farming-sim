package game;
import java.util.Scanner;
import crops.Crop;
import farm.Farm;
import farm.Farmer;


/**
 * Game class - acts as game environment.
 * Runs game through console
 * Does not check whether input is valid as this is only for development purposes.
 */
public class ConsoleGame extends Game {

    private static Scanner scanner;

    /**
     * Initialize the game
     */
    public ConsoleGame() {
        super();
        ConsoleGame.scanner = new Scanner(System.in);
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
        Game.farm = new Farm("FarmName");
        Game.farmer = new Farmer("FarmerName");
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
        String input = ConsoleGame.scanner.nextLine();
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
                this.end();
                break;
            case "end day":
                Game.increaseDayCounter();
                break;
            case "view farm name":
                System.out.println(Game.farm.getName());
                break;
            case "view farm":
                break;
            case "view farmer name":
                System.out.println(Game.farmer.getName());
                break;
            case "view game length":
                System.out.println(this.getGameLength() + " days");
                break;
            case "visit store":
                ConsoleGame.visitStore();
                break;
            default:
                System.out.println("Unknown action: " + userInput);
        }
    }

    public void viewFarm() {
        System.out.println(Game.farm.toString());

    }

    public static void visitStore() {
        while(true) {   // Yeah i know its bad to idc
            System.out.println("What would you like to do at the store?");
            String item = ConsoleGame.scanner.nextLine().toLowerCase();
            switch (item) {
                case "leave":
                    return;
                case "view items":
                    ConsoleGame.viewStore();
                    return;
                case "buy":
                	ConsoleGame.buyItem();
                    return;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }


    /**
     * Show the available store items
     */
    private static void viewStore() {
        System.out.println("Crops:");
        for (String name : Game.store.getCropNames()) {
            Crop crop = Game.store.getCrop(name);
            System.out.println(crop.getName() + " ($" + crop.getBuyPrice() + ")");
        }
    }

    /**
     * Ask the user what they want to buy
     */
    private static void buyItem() {
        boolean done = false;
        String item = "";

        while (!done) {
            System.out.println("What would you like to buy?");
            item = ConsoleGame.scanner.nextLine().toLowerCase();

            if (Game.store.getCropNamesLowerCase().contains(item) || item.equals("nothing")) {
                done = true;
            } else {
                System.out.println("Unknown item: " + item);
                System.out.println("Try an item from the following: " + Game.store.getCropNames());
            }
        }
        System.out.println("Bought " + item);
    }

    public static void main(String[] args) {
        ConsoleGame game = new ConsoleGame();
        game.run();
    }
}
