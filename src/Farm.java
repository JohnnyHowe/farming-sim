
/**
 * Class representing the farm.
 * Is the environment for the game.
 */
public class Farm
{
	private String name;

	// Defaults for bounuses
//	private int growthMod = 1;
//	private int happinessMod = 1;
//	private int incomeMod = 1;
//	private boolean storeDiscount;

	/**
	 * Constructor for the farm
	 * @param name Name of farm
	 */
	public Farm (String name)
	{
		this.name = name;
	}

	/**
	 * Gets the name of the farm
	 * @return name of farm
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * Returns a string representation of the farm.
	 * In the form "This is farm {farm name}."
	 * @return string representation of farm
	 */
	public String toString()
	{
		return "This is farm " + name + ".";
	}
}
