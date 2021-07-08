package controles;

import java.util.ArrayList;
import java.util.List;

import entidades.Funcionario;
import exception.FuncionarioJaExistenteException;
import exception.FuncionarioNaoExistenteException;

public class GerenteFuncionario {
	
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public void  addFuncionario(Funcionario f) throws FuncionarioJaExistenteException {
		for(Funcionario f1: this.funcionarios) {
			if(f1.getCpf().equalsIgnoreCase(f.getCpf())) {
				throw new FuncionarioJaExistenteException();
			}
		}
		this.funcionarios.add(f);
	}

	public Funcionario buscarFuncionario(String cpf) throws FuncionarioNaoExistenteException {
		for(Funcionario f: this.funcionarios) {
			if(f.getCpf().equalsIgnoreCase(cpf)) {
				return f;
			}
			
		}
		throw new FuncionarioNaoExistenteException();
	}
	
	public List<Funcionario> mostrarFuncionariosComGratificacao(){
		List<Funcionario> fs = new ArrayList<Funcionario>();
		for(Funcionario f: funcionarios) {
			if(f.getGratificacao() > 0) {
				fs.add(f);
			}			
		}
		return fs;
	}

}
