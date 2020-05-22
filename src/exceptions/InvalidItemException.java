package exceptions;

/**
 * @author Alex Burling (arb142)
 */
public class InvalidItemException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2553761766601848852L;

	/**
	 * 
	 */
	public InvalidItemException() {
		super("You can't use that item like that!");
	}
}
