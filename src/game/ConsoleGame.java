package game;
import java.util.Scanner;
import crops.Crop;
import exceptions.InvalidActionException;
import exceptions.OutOfActionsException;
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
     * @param farmerName 
     * @param farmName 
     * @param gameLen 
     */
    public ConsoleGame(int gameLen, String farmName, String farmerName) {
        super();
        farm = new Farm(farmName);
        farmer = new Farmer(farmerName);
        gameLength = gameLen;
        ConsoleGame.scanner = new Scanner(System.in);
    }

    /**
     * Set up the game
     * Creates Farm, Farmer
     */
    public void setUp() {
;
    }

    /**
     * Prints the end game string to the console.
     * String in the form "You ended the game with {points} points."
     * points is the returned value from the calculatePoints method.
     */
    public void end() {
        System.out.println("You ended the game with " + ConsoleGame.getInstance().getPoints() + " points.");
        System.exit(0);
    }

    /**
     * runDay serves as the code inside the main game loop.
     */
    public void runDay() {
        System.out.println("\nWhat are you going to do today? (Day " + (Game.getInstance().getCurrentDay() + 1) + ")");
        String input = ConsoleGame.scanner.nextLine();
        this.runInput(input);
    }

    /**
     * Given a string from the user input, run some command
     *
     * "end game" finishes the game, even if not all days are completed.
     *
     * @param userInput String string
     */
    private void runInput(String userInput) {
    	Game.Actions input = Actions.HELP;
    	
    	try {
			input = inputParser(userInput);
		} catch (InvalidActionException e) {
			System.out.println("Unknown Command:" + e.getMessage());
		}
    	
    	try {
			ActionHandler.handle(input);
		} catch (OutOfActionsException e) {
			System.out.println(e.getMessage());
		}
    }
   
    private Game.Actions inputParser(String input) throws InvalidActionException {
    	switch (input.trim().toLowerCase()) {
    		case "tend farmland":
    			return Actions.TEND_FARM;
    		case "tend crops":
    			return Actions.TEND_CROPS;
    		case "harvest crops":
    			return Actions.HARVEST_CROPS;
    		case "play with animals":
    			return Actions.PLAY_ANIMALS;
    		case "feed animals":
    			return Actions.FEED_ANIMALS;
    		case "visit store":
    			return Actions.VISIT_STORE;
    		case "end day":
    			return Actions.END_DAY;
    		case "end game":
    			return Actions.END_GAME;
    		case "help":
    			return Actions.HELP;
    		default:
    			throw new InvalidActionException(input.trim().toLowerCase());
    	}
    }

    public void viewFarm() {
        System.out.println(Game.farm.toString());

    }

    public void visitStore() {
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
    
    public void displayHelp() {
		System.out.println("Commands:\nTend Farmland\nTend Crops\nHarvest Crops\nPlay with Animals\nFeed Animals\nVisit Store\nEnd Day\nEnd Game\nHelp(this)");
	}

    public static void main(String[] args) {
    	
    /*regular game code
      Scanner in = new Scanner(System.in);
      System.out.println("How many days will the game last?: ");
      int gameLen = Integer.parseInt(in.nextLine());
      System.out.println("Farm name: ");
      String farmName = in.nextLine();
      System.out.println("Farmer name: ");
      String farmerName = in.nextLine();
      in.close();
      */

      // Dev test code
    	int gameLen = 10;
    	String farmName = "DEVFarmName";
    	String farmerName = "DEVFarmerName";
        ConsoleGame game = new ConsoleGame(gameLen, farmName, farmerName);
        game.run();
    }
}
