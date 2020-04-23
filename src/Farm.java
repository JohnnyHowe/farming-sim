import java.util.Scanner;

public class Farm {
	
	String name;
	Farmer farmer;
	int gameLength,day= 0, farmType, growthMod = 1, happinessMod = 1, incomeMod = 1;
	boolean storeDiscount;
	
	public Farm (String name, String farmerName) {
		this.name = name;
		this.farmer = new Farmer(farmerName);
	}
	
	public void printFarm () {
		System.out.println("This is farm " + name + " and it is occupied by farmer " + farmer.getName());
	}
	
	public void nextDay() {
		this.day += 1;
		if (this.day == this.gameLength) {
			this.endGame();
		}
	}
	
	public void endGame() {
		System.out.println("You ended the game with " + calculatePoints() + " points.");
	}
	
	public int calculatePoints() {
		return 69420;
	}
	
	public static Farm setUpFarm(Scanner in) {
		System.out.println("Enter farm name:");
		String farmName = in.nextLine();
		System.out.println("Enter farmer name:");
		String farmerName = in.nextLine();
		System.out.println("What type of farm do you want to start with? ((0,Humble), Range, Field, (3,Wealthy))");
		int farmType = in.nextInt();
		Farm farm = new Farm(farmName, farmerName);
		switch (farmType) {
			case 0:
				farm.storeDiscount = true;
				break;
			case 1:
				farm.happinessMod += 1;
				farm.growthMod -= 1;
				farm.storeDiscount = false;
				break;
			case 2:
				farm.happinessMod -= 1;
				farm.growthMod += 1;
				farm.storeDiscount = false;
				break;
			case 3:
				farm.incomeMod += 1;
				farm.storeDiscount = false;
			default:
				farmType = 0;
				break;
		}
		farm.printFarm();
		System.out.println("How long should this game last?");
		farm.gameLength = in.nextInt();
		return farm;
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		farm = setUpFarm(in);
		
		in.close();
		
	}
	
}
