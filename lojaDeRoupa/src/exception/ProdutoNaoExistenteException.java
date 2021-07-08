package exception;

public class ProdutoNaoExistenteException extends Exception
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ProdutoNaoExistenteException() {
		super("Produdo não encontrado");
	}

}
