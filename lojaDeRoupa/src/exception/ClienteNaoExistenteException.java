package exception;

public class ClienteNaoExistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ClienteNaoExistenteException() {
		super("Cliente não encontrado!");
	}

}
