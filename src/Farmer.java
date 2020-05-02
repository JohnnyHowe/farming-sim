/**
 * Class to represent the farmer
 */
public class Farmer
{
	private String name;
	private float money;

	/**
	 * Initialize the farmer.
	 * @param name Name of farmer.
	 */
	public Farmer(String name)
	{
		this.name = name;
		this.money = 0;
	}

	/**
	 * Get the money the player has
	 * @return money Money player has
	 */
	public float getMoney()
	{
		return this.money;
	}

	/**
	 * Get the farmers name
	 * @return name Name of farmer
	 */
	public String getName()
	{
		return this.name;
	}
}
