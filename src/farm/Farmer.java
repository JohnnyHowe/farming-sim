package farm;

import game.Game;

/**
 * Class to represent the farmer
 */
public class Farmer
{
	private String name;
	private float money = 100;
	private int actionsToday = 0;;

	/**
	 * Resets farmer actions to 0
	 */
	public void resetActions() {
		actionsToday = 0;
	}
	
	public boolean canWork() {
		return actionsToday < 2; //maybe we can define this elsewhere as not a magic number?
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
	
	public void setName(String name) {
		Game.getFarmer().name = name;
	}
	
	public void addMoney(float money) {
		this.money += money * Game.getFarm().incomeMod;
	}

	/**
	 * Decrease the amount of money the player has if they have enough.
	 * @param money spending amount
	 * @return whether the money was taken
	 */
	public boolean spendMoney(float money) {
		if (this.hasFunds(money)) {
			this.money -= money;
			return true;
		} else {
			return false;
		}
	}
}
