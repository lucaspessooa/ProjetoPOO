package exception;

public class FuncionarioNaoExistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FuncionarioNaoExistenteException() {
		super("Funcionário não encontrado");
	}
	
	

}
