package exception;

public class FuncionarioJaExistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FuncionarioJaExistenteException() {
		super("Funcion�rio J� existente");
	}

}
