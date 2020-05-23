package items;

public class Grain extends Item {

	private final static String GRAIN_NAME = "Grain";		
	private final static String GRAIN_DESC = "A small handful of grain and seeds";		
	private final static float GRAIN_PRICE = 2;			
	private final static String GRAIN_EFFECT = "health";	
	private final static float GRAIN_MULT = 2;	
	private final static FarmItems GRAIN_ENUM = FarmItems.GRAIN;
	
	public Grain(){
		super(GRAIN_NAME, GRAIN_DESC, GRAIN_PRICE, GRAIN_EFFECT, GRAIN_MULT, GRAIN_ENUM);
	}

}
