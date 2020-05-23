package exceptions;

/**
 * @author Alex Burling (arb142)
 */
public class InsufficientFundsException extends Exception {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -5026953989613636855L;

	/**
	 * 
	 */
	public InsufficientFundsException() {
		super("You don't have enough money for that!");
	}
	
	public InsufficientFundsException(String message) {
		super(message);
	}
}