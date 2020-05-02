import java.util.Scanner;

public class Farm
{
	// Game state info
	String name;
	Farmer farmer;
	int gameLength;		// Number of days the game will run for
	int day;			// Current in game day
//	int farmType;	// This will be implimented through child classes

	// Defaults for bounuses
	int growthMod = 1;
	int happinessMod = 1;
	int incomeMod = 1;
	boolean storeDiscount;

	/**
	 * Constructor for the farm ... ADD MORE INFO
	 * @param {String} name - Name of farm
	 * @param {Farmer} farmer - Farmer running the farm
	 */
	public Farm (String name, Farmer farmer)
	{
		this.name = name;
        this.farmer = farmer;
		this.day = 0;
	}

	/**
	 * Set up a new farm.
	 * Get the parameters by asking the player through the console.
	 * @return {Farm} new farm
	 */
	public static Farm setUpFarmFromConsole() {
		Scanner in = new Scanner(System.in); 	// Create a text scanner to get console input

		// Get game info from player
		System.out.println("Enter farm name:");
		String farmName = in.nextLine();
		System.out.println("Enter farmer name:");
		String farmerName = in.nextLine();
		System.out.println("What type of farm do you want to start with? ((0,Humble), Range, Field, (3,Wealthy))");
		int farmType = in.nextInt();

		// Create farmer and farm
        Farmer farmer = new Farmer(farmerName);
		Farm farm = new Farm(farmName, farmer);

		// Last bit of info from player
		System.out.println("How long should this game last?");
		farm.gameLength = in.nextInt();

		in.close();		// Close the input scanner

		System.out.println(farm.toString());
		return farm;
	}

	/**
	 * Returns a string representation of the farm.
	 * In the form "This is farm {farm name} and it is occupied by farmer {farmer name}."
	 */
	public String toString()
	{
		return "This is farm " + name + " and it is occupied by farmer " + farmer.getName() + ".";
	}

	/**
	 * Increase the day counter by 1.
	 * If the game has reached the max days, run the endGame method.
	 */
	public void nextDay()
	{
		this.day += 1;
		if (this.day == this.gameLength) {
			this.endGame();
		}
	}

	/**
	 * Prints the end game string to the console.
	 * String in the form "You ended the game with {points} points."
	 * points is the returned value from the calculatePoints method.
	 */
	public void endGame()
	{
		System.out.println("You ended the game with " + getPoints() + " points.");
	}

	/**
	 * Returns the points the player has earned.
	 * @return {int} game points
	 */
	public int getPoints()
	{
		return 69420;
	}

	/**
	 * Set up farm (from console input currently)
	 * ...
	 */
	public static void main(String[] args) {
		Farm farm = setUpFarmFromConsole();
		farm.endGame();
	}
}
