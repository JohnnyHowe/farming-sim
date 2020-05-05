package crops;
import farmSim.Crop;


/**
 * Class to represent Wheat
 */
public class Wheat extends Crop {
	
    public Wheat(String name, String description, float price) {
		super(CropList.WHEAT_NAME, CropList.WHEAT_DESC, CropList.WHEAT_PRICE, CropList.WHEAT_INCOME);
	}

}
