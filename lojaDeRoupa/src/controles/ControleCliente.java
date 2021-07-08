package controles;

import java.util.ArrayList;
import java.util.List;

import entidades.Cliente;
import exception.ClienteJaExistenteException;
import exception.ClienteNaoExistenteException;

public class ControleCliente {
	
	
	private List<Cliente> clientes = new ArrayList<Cliente>();

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void addClientes(Cliente c)throws ClienteJaExistenteException{
		for(Cliente c1: clientes) {
			if(c1.getCpf().equalsIgnoreCase(c.getCpf())) {
				throw new ClienteJaExistenteException();
			}
		}
		this.clientes.add(c);
	}
	
	public Cliente buscarCliente(String cpf) throws ClienteNaoExistenteException{
		for (Cliente c: this.clientes) {
			if(c.getCpf().equalsIgnoreCase(cpf)) {
				return c;
			}
						
		}
		throw new ClienteNaoExistenteException();
	}
	
	public List<Cliente> buscarClientesComPagamentoNoCartao(){
		List<Cliente> cl = new ArrayList<Cliente>();
		for(Cliente c: clientes) {
			if(c.getTipoDePagamento().equalsIgnoreCase("cartão")) {
				cl.add(c);
			}
		}
		return cl;
	}
	
	

}
