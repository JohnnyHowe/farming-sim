package items;

/**
 * Class to represent Bonemeal Item
 * Item functions in game as a daily action booster
 * @see CropList
 */
public class Bonemeal extends Item {
	public Bonemeal() {
		super(ItemList.BONE_NAME, ItemList.BONE_DESC, ItemList.BONE_PRICE, ItemList.BONE_EFFECT, ItemList.BONE_MULT);
	}
}
