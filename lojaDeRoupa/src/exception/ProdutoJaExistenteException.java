package exception;

public class ProdutoJaExistenteException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProdutoJaExistenteException() {
		super("Produto já cadastrado");
	}

}
