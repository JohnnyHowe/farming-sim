package crops;

import farmSim.Crop;

public class Melon extends Crop {
	
    public Melon(String name, String description, float price) {
		super(CropList.MELON_NAME, CropList.MELON_DESC, CropList.MELON_PRICE, CropList.MELON_INCOME);
	}

}
