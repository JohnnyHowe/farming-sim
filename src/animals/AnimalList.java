package animals;

import java.util.Dictionary;
import java.util.Hashtable;


public class AnimalList {

	public static Dictionary<String, Animal> GetAllAnimals() {
		Dictionary<String, Animal> allAnimals = new Hashtable<String, Animal>();

		allAnimals.put(COW_NAME, new Cow());
		allAnimals.put(SHEEP_NAME, new Sheep());
		allAnimals.put(CHICKEN_NAME, new Chicken());

		return allAnimals;
	}

	/*
	 * Static, Constant definitions of animal attributes (promotes consistency and removal of "magic numbers"
	 * ALL VALUES ARE PLACEHOLDER
	 * feel free to change as needed
	 */
	
	//COW
	public final static String COW_NAME = "Cow";	//Display Name
	public final static String COW_DESC = "MOO";	//Description
	public final static double COW_PRICE = 2;		//Base Price
	public final static double COW_DAILY_PROF = 100;//Money gained by player at the end of each day
	public final static double COW_BASE_HEALTH = 5;	//Base and Max health
	public final static double COW_BASE_MOOD = 5;	//Base and Max mood
	
	//SHEEP
	public final static String SHEEP_NAME = "Sheep";
	public final static String SHEEP_DESC = "BAA";
	public final static double SHEEP_PRICE = 2;
	public final static double SHEEP_DAILY_PROF = 100;
	public final static double SHEEP_BASE_HEALTH = 5;
	public final static double SHEEP_BASE_MOOD = 5;
	
	//CHICKEN
	public final static String CHICKEN_NAME = "Chicken";
	public final static String CHICKEN_DESC = "CLUCK";
	public final static double CHICKEN_PRICE = 2;
	public final static double CHICKEN_DAILY_PROF = 100;
	public final static double CHICKEN_BASE_HEALTH = 5;
	public final static double CHICKEN_BASE_MOOD = 5;
}
