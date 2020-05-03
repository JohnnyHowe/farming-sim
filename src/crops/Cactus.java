package crops;

import farmSim.Crop;

public class Cactus extends Crop {
	
    public Cactus(String name, String description, float price) {
		super(CropList.CACTUS_NAME, CropList.CACTUS_DESC, CropList.CACTUS_PRICE, CropList.CACTUS_INCOME);
	}

}
