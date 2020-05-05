package crops;

import farmSim.Crop;

public class Mushroom extends Crop {
	
    public Mushroom(String name, String description, float price) {
		super(CropList.MUSH_NAME, CropList.MUSH_DESC, CropList.MUSH_PRICE, CropList.MUSH_INCOME);
	}

}
