package exceptions;

/**
 * @author Alex Burling (arb142)
 */
public class InvalidActionException extends Exception {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = -6832037948940277007L;

	/**
	 * 
	 */
	public InvalidActionException() {
		super("That isn't a valid action.");
	}
	
	public InvalidActionException(String message) {
			super(message);
	}
}
