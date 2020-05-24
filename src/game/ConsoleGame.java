package game;
import java.util.Scanner;

import exceptions.InvalidActionException;
import exceptions.OutOfActionsException;
import farm.FarmItem;

/**
 * Game sub class - acts as game environment. Built on a pseudo singleton structure,
 * handles the creation of each other singleton within the simulator.
 * Acts as implementation for specific i/o e.g. console
 * @author Alex Burling(arb142), Jonathon Howe(joh29)
 * @see Game
 */
public class ConsoleGame extends Game {

    private static Scanner scanner;
    public static boolean atStore;

    /**
     * Constructor for ConsoleGame, same as super however initializes and stores a scanner
     * @param length int Game length in days
     */
    public ConsoleGame(int length) {
        super(length);
        ConsoleGame.scanner = new Scanner(System.in);
    }


    /**
     * Prints the end game string to the console.
     * String in the form "You ended the game with {points} points."
     * points is the returned value from the getScore method.
     */
    public void endGame() {
        System.out.println("You ended the game with " + ConsoleGame.getInstance().getScore() + " points.");
        System.exit(0);
    }

    /**
     * runDay serves as the code inside the main game loop.
     */
    public void runDay() {
        System.out.println("\nWhat are you going to do today? (Day " + (Game.getInstance().getCurrentDay() + 1) + ")");
        handleInput();
    }
    
    private void printInfo() {
        System.out.println(Game.getFarm().toString());
        System.out.println("It's day " + (Game.getInstance().getCurrentDay() + 1) + "/" + Game.getInstance().getGameLength() + 
        		". You have $" + Game.getFarmer().getMoney() + " and " +
        (2 - Game.getFarmer().getActions()) + " action(s) left.");
        System.out.println("You have 9 paddocks, which contain: ");
        for (FarmItem item: Game.getFarm().getPaddockItems()) {
            System.out.println(item.getName());
        }
        System.out.println();
        System.out.println("You have the following consumables:");
        for (FarmItem item: Game.getFarm().getConsumables()) {
            System.out.println(item.getName());
        }
    }

    /**
     * Takes user input from commandline, parses, and handles action
     * accordingly. Catches relevant exceptions.
     */
    private void handleInput() {
        String userIn = ConsoleGame.scanner.nextLine();
    	Game.Actions input = Actions.HELP;
    	
    	try {
			input = inputParser(userIn);
		} catch (InvalidActionException e) {
			System.out.println("Unknown Command:" + e.getMessage());
		}
    	if (input == Actions.INFO) {
    		printInfo();
    	} else {
        	try {
    			ActionHandler.handle(input);
    		} catch (OutOfActionsException e) {
    			System.out.println(e.getMessage());
    		}
    	}
    }
   
    /**
     * Handles dirty user input 
     * @param input String input from scanner in
     * @return Game.Actions an enum to pass to ActionHandler
     * @throws InvalidActionException
     * @see ActionHandler
     */
    private Game.Actions inputParser(String input) throws InvalidActionException {
    	switch (input.replace(" ", "").toLowerCase()) {
    		case "tendfarmland": return Actions.TEND_FARM;
    		
    		case "tendcrops": return Actions.TEND_CROPS;
    		
    		case "harvestcrops": return Actions.HARVEST_CROPS;
    		
    		case "playwanimals": return Actions.PLAY_ANIMALS;
    		
    		case "feedanimals": return Actions.FEED_ANIMALS;
    		
    		case "visitstore": return Actions.VISIT_STORE;
    		
    		case "endday": return Actions.END_DAY;
    		
    		case "endgame": return Actions.END_GAME;
    		
    		case "help": return Actions.HELP;
    		
    		case "farmstatus": return Actions.INFO;
    		
    		default: throw new InvalidActionException(input.replace(" ", "").toLowerCase());
    	}
    }

    private Game.StoreActions storeInputParser(String input) throws InvalidActionException {
    	switch (input.replace(" ", "").toLowerCase()) {
    		case "viewstock": return StoreActions.VIEW_STOCK;
    		
    		case "buy": return StoreActions.BUY;
    		
    		case "sell": return StoreActions.SELL;
    		
    		case "leave": return StoreActions.LEAVE;
    		
    		case "help": return StoreActions.HELP;
    		
    		default: throw new InvalidActionException(input.replace(" ", "").toLowerCase());
    	}
    }
    
    public void visitStore() {
    	atStore = true;
        while(atStore) {
            System.out.println("What would you like to do at the store?");
            String userIn = ConsoleGame.scanner.nextLine();
        	Game.StoreActions input = StoreActions.HELP;
        	
        	try {
    			input = storeInputParser(userIn);
    		} catch (InvalidActionException e) {
    			System.out.println("Unknown Command:" + e.getMessage());
    		}
    		ActionHandler.storeHandle(input);
            }
    }


    /**
     * Show the available store items
     */
    private static void viewStore() {
    	;/*
        System.out.println("Crops:");
        for (String name : Game.getStore().getCropNames()) {
            Crop crop = Game.getStore().getCrop(name);
            System.out.println(crop.getName() + " ($" + crop.getBuyPrice() + ")");
        }
        */
    }

    /**
     * Ask the user what they want to buy
     */
    private static void buyItem() {
    	;
    	/*
        boolean done = false;
        String item = "";

        while (!done) {
            System.out.println("What would you like to buy?");
            item = ConsoleGame.scanner.nextLine().toLowerCase();

            if (Game.getStore().getCropNames().contains(item) || item.equals("nothing")) {
                done = true;
            } else {
                System.out.println("Unknown item: " + item);
                System.out.println("Try an item from the following: " + Game.getStore().getCropNames());
            }
        }
        System.out.println("Bought " + item);
        */
    }
    
    /**
     * Prints a string displaying all available commands to System.out
     */
    public void displayHelp() {
		System.out.println("Commands:\nTend Farmland\t|Tend Crops\t|Harvest Crops\n"
				+ "Play w Animals\t|Feed Animals\t|Visit Store\n"
				+ "End Day\t\t|End Game\t|Help(this)\n"
				+ "Farm Status");
	}
    
    public void displayStoreHelp() {
    	System.out.println("Store Commands:\nView Stock\t|Buy\t|Sell\nLeave");
    }

    public static void main(String[] args) {
    	/* console game start code
        Scanner in = new Scanner(System.in);
        System.out.println("How many days will the game last?: ");
        gameInstance = new ConsoleGame(Integer.parseInt(in.nextLine()));
        System.out.println("Farm name: ");
        Game.getFarm().setName(in.nextLine());
        System.out.println("Farmer name: ");
        Game.getFarmer().setName(in.nextLine());
        in.close();
        */
        
    	//dev quickstart code
    	new ConsoleGame(10);
    	Game.getFarm().setName("DEVFarmName");
    	Game.getFarmer().setName("DEVFarmerName");
        Game.getInstance().run();
        //TODO split run to static
    }

}
