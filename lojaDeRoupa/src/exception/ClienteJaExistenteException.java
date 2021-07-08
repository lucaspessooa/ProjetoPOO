package exception;

public class ClienteJaExistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ClienteJaExistenteException() {
		super("Cliente já existente!");
	}

}
