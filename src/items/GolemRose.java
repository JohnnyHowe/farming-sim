package items;

/**
 * Class to represent Golem Rose Item
 * Item functions in game as a daily action booster
 * @see CropList
 */
public class GolemRose extends Item {
	public GolemRose() {
		super(ItemList.ROSE_NAME, ItemList.ROSE_DESC, ItemList.ROSE_PRICE, ItemList.ROSE_EFFECT, ItemList.ROSE_MULT);
	}
}
