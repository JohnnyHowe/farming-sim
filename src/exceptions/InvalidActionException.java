package exceptions;

/**
 * @author Alex Burling (arb142)
 */
public class InvalidActionException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3062656714637574054L;

	/**
	 * 
	 */
	public InvalidActionException() {
		super("That isn't a valid action.");
	}
}
