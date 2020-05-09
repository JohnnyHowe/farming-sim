package farmSim;
/**
 * Class to represent the farmer
 */
public class Farmer
{
	private String name;
	private double money;

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
	public double getMoney()
	{
		return this.money;
	}

	/**
	 * Does the farmer have the funds?
	 * @param cost Funds to check for
	 * @return Whether the farmer has the funds
	 */
	public boolean hasFunds(float cost) {
		return this.money >= cost;
	}

	/**
	 * Get the farmers name
	 * @return name Name of farmer
	 */
	public String getName()
	{
		return this.name;
	}
	
	public void addMoney(double money) {
		this.money += money;
	}
}
