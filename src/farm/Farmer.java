package farm;

import game.Game;

/**
 * Class to represent the farmer
 */
public class Farmer
{
	private String name;
	private float money = 100;
	private int actionsToday = 0;
	
	/**
	 * @return boolean actionsToday < 2
	 */
	public boolean canWork() {
		return actionsToday < 2;
	}
	
	/**
	 * @return int returns actionsToday
	 */
	public int getActions() {
		return actionsToday;
	}
	
	/**
	 * Increments actionsToday by one
	 */
	public void work() {
		actionsToday += 1;
	}
	
	/**
	 * Resets farmer actions to 0
	 */
	public void resetActions() {
		actionsToday = 0;
	}

	/**
	 * Simple boolean function to check if the farmer has enough cash for
	 * store item.
	 * @param cost Funds to check for
	 * @return boolean money >= cost
	 */
	public boolean hasFunds(float cost) {
		return money >= cost;
	}

	/**
	 * Get the farmer's name
	 * @return name String Farmer's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Set the farmer's name
	 * @param name String Farmer's name
	 */
	public void setName(String newName) {
		name = newName;
	}
	
	public float getMoney() {
		return money;
	}
	
	/**
	 * Adds to farmer's money
	 * Note, money is multiplied by farm's incomeMod before adding to total.
	 * @param money float Cash to add
	 */
	public void addMoney(float amount) {
		money += amount * Game.getFarm().getMod("income");
	}

	/**
	 * Decrease the amount of money the player has if they have enough.
	 * @param money spending amount
	 * @return whether the money was taken
	 */
	public boolean spendMoney(float money) {
		if (hasFunds(money)) {
			money -= money;
			return true;
		} else {
			return false;
		}
	}
}
