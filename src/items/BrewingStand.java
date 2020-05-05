package items;

/**
 * Class to represent Brewing Stand Item
 * Item functions in game as a daily action booster
 * @see CropList
 */
public class BrewingStand extends Item {
	public BrewingStand() {
		super(ItemList.STAND_NAME, ItemList.STAND_DESC, ItemList.STAND_PRICE, ItemList.STAND_EFFECT, ItemList.STAND_MULT);
	}
}
