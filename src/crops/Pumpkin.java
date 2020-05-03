package crops;

import farmSim.Crop;

public class Pumpkin extends Crop {
	
    public Pumpkin(String name, String description, float price) {
		super(CropList.PUMP_NAME, CropList.PUMP_DESC, CropList.PUMP_PRICE, CropList.PUMP_INCOME);
	}

}
