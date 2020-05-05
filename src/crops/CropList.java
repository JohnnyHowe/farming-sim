package crops;

import java.util.Dictionary;
import java.util.Hashtable;

/**
 * Class to easily manipulate crop attributes
 */
public abstract class CropList
{
	public static Dictionary<String, Crop> GetAllCrops() {
		Dictionary<String, Crop> allCrops = new Hashtable<String, Crop>();

		allCrops.put("wheat", new Crop("Wheat", "Wheaty wheat", 2, 100, 5));
		allCrops.put("sugar cane", new Crop("Sugar Cane", "Sugary Cane", 3, 150, 5));
		allCrops.put(CACTUS_NAME, new Crop(CACTUS_NAME, CACTUS_DESC, CACTUS_PRICE, CACTUS_INCOME, CACTUS_THRESHOLD));//two different methods of initialization
		allCrops.put(MUSH_NAME, new Crop(MUSH_NAME, MUSH_DESC, MUSH_PRICE, MUSH_INCOME, MUSH_THRESHOLD));
		allCrops.put(MELON_NAME, new Crop(MELON_NAME, MELON_DESC, MELON_PRICE, MELON_INCOME, MELON_THRESHOLD));
		allCrops.put(PUMP_NAME, new Crop(PUMP_NAME, PUMP_DESC, PUMP_PRICE, PUMP_INCOME, PUMP_THRESHOLD));

		return allCrops;
	}

	/*
	 * Static, Constant definitions of crop attributes (promotes consistency and removal of "magic numbers"
	 * ALL VALUES ARE PLACEHOLDER
	 * feel free to change as needed
	 */
	
	//WHEAT
	public final static String WHEAT_NAME = "Wheat";		//Display Name
	public final static String WHEAT_DESC = "Wheaty wheat";	//Description
	public final static double WHEAT_PRICE = 2;				//Base Price
	public final static double WHEAT_INCOME = 100;			//Money gained by player on harvest
	public final static double WHEAT_THRESHOLD = 5;			//Minimum value of grown to .isGrown() == True
	
	//SUGARCANE
	public final static String CANE_NAME = "Sugar Cane";
	public final static String CANE_DESC = "Sugary cane";
	public final static double CANE_PRICE = 3;
	public final static double CANE_INCOME = 150;
	public final static double CANE_THRESHOLD = 5;	
	
	//CACTUS
	public final static String CACTUS_NAME = "Cactus";
	public final static String CACTUS_DESC = "Ouch, Prickly";
	public final static double CACTUS_PRICE = 5;
	public final static double CACTUS_INCOME = 250;
	public final static double CACTUS_THRESHOLD = 5;	
	
	//MUSHROOM
	public final static String MUSH_NAME = "Mushroom";
	public final static String MUSH_DESC = "Kind of, mushy...";
	public final static double MUSH_PRICE = 4;
	public final static double MUSH_INCOME = 200;
	public final static double MUSH_THRESHOLD = 5;	
	
	//MELON
	public final static String MELON_NAME = "Melon";
	public final static String MELON_DESC = "Watermelone";
	public final static double MELON_PRICE = 6;
	public final static double MELON_INCOME = 300;
	public final static double MELON_THRESHOLD = 5;	
	
	//PUMPKIN
	public final static String PUMP_NAME = "Pumpkin";
	public final static String PUMP_DESC = "Carve and place on head to defeat Endermen!";
	public final static double PUMP_PRICE = 7;
	public final static double PUMP_INCOME = 350;
	public final static double PUMP_THRESHOLD = 5;	
}