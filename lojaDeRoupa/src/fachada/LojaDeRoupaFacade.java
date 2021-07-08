package fachada;

import java.io.IOException;
import java.util.List;

import arquivo.Gravador;
import controles.ControleCliente;
import controles.GerenteDeProduto;
import controles.GerenteFuncionario;
import entidades.Cliente;
import entidades.Funcionario;
import entidades.Produto;
import exception.ClienteJaExistenteException;
import exception.ClienteNaoExistenteException;
import exception.FuncionarioJaExistenteException;
import exception.FuncionarioNaoExistenteException;
import exception.ProdutoJaExistenteException;
import exception.ProdutoNaoExistenteException;

public class LojaDeRoupaFacade {
	
	private ControleCliente c = new ControleCliente();
	private GerenteDeProduto p = new GerenteDeProduto();
	private GerenteFuncionario f = new GerenteFuncionario();
	private Gravador g = new Gravador();
	
	
	public void addCliente(Cliente cliente) throws ClienteJaExistenteException {
		c.addClientes(cliente);		
	}
	
	public List<Cliente> getClientes(){
		return c.getClientes();
	}
	
	public Cliente buscarCliente(String cpf) throws ClienteNaoExistenteException {
		return c.buscarCliente(cpf);
	}
	
	public List<Cliente> buscarClientesComPagamentoNoCartao(){
		return c.buscarClientesComPagamentoNoCartao();
	}
	
	public List<Funcionario> getFuncioniarios(){
		return f.getFuncionarios();
	}
	
	public List<Produto> getProdutos(){
		return p.getProdutos();
	}
	
	public void addFuncionario(Funcionario funcionario) throws FuncionarioJaExistenteException {
		f.addFuncionario(funcionario);
	}
	
	public Funcionario buscarFuncionario(String cpf) throws FuncionarioNaoExistenteException {
		return f.buscarFuncionario(cpf);
	}
	
	public List<Funcionario> mostrarFuncionariosComGratificacao(){
		return f.mostrarFuncionariosComGratificacao();
		
	}
	
	public void addProdutos(Produto produto) throws ProdutoJaExistenteException {
		p.addProdutos(produto);
		
	}
	
	public Produto buscarProdutoPorCodigo(String codigo) throws ProdutoNaoExistenteException {
		return p.buscarProdutoPorCodigo(codigo);
	}
	
	public void removerProduto(Produto produto) throws ProdutoNaoExistenteException {
		p.removerProduto(produto);
		
	}
	
	public List<Produto>buscarProdutoPorCategoria(String categoria) throws ProdutoNaoExistenteException{
		return p.buscarProdutoPorCategoria(categoria);
	}
	
	public double totalEstoque() {
		return p.totalEstoque();
	}
	
	public void gravarProduto(List<String> texto, String nomeDoArquivo) throws IOException {
		g.gravarProduto(texto, nomeDoArquivo);
	}
	
	public List<String> buscarTotal(String nome) throws IOException{
		return g.buscarProduto(nome);
	}
}
