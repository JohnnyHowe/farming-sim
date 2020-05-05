package crops;

import farmSim.Crop;

public class SugarCane extends Crop {
	
    public SugarCane(String name, String description, float price) {
		super(CropList.CANE_NAME, CropList.CANE_DESC, CropList.CANE_PRICE, CropList.CANE_INCOME);
	}

}
