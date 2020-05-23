package exceptions;

/**
 * @author Alex Burling (arb142)
 */
public class OutOfActionsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8454750891903320189L;

	/**
	 * 
	 */
	public OutOfActionsException() {
		super("You are out of daily actions.");
	}
	
	public OutOfActionsException(String message) {
		super(message);
	}
}
