package items;

/**
 * Class to represent Brush Item
 * Item functions in game as a daily action booster
 * @see CropList
 */
public class Brush extends Item {
	public Brush() {
		super(ItemList.BRUSH_NAME, ItemList.BRUSH_DESC, ItemList.BRUSH_PRICE, ItemList.BRUSH_EFFECT, ItemList.BRUSH_MULT);
	}
}
