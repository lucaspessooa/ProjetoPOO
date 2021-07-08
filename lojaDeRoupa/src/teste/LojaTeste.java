package teste;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import entidades.Cliente;
import entidades.Funcionario;
import entidades.Produto;
import exception.ClienteJaExistenteException;
import exception.ClienteNaoExistenteException;
import exception.FuncionarioJaExistenteException;
import exception.FuncionarioNaoExistenteException;
import exception.ProdutoJaExistenteException;
import exception.ProdutoNaoExistenteException;
import fachada.LojaDeRoupaFacade;
import junit.framework.Assert;

class LojaTeste {
	
	private LojaDeRoupaFacade loja = new LojaDeRoupaFacade();

	@Test
	void testAddCliente() throws ClienteJaExistenteException {
		Cliente c = criarClientePadrao();
		loja.addCliente(c);
		List<Cliente> clientes = loja.getClientes();
		assertEquals(1,clientes.size());
		
	}

	@Test
	void testBuscarCliente() throws ClienteJaExistenteException, ClienteNaoExistenteException {
		Cliente c = criarClientePadrao();
		loja.addCliente(c);
		assertEquals(c,loja.buscarCliente(c.getCpf()));		
	}

	
	@Test
	void testAddFuncionario() throws FuncionarioJaExistenteException {
		Funcionario f = criarFuncionarioPadrao();
		loja.addFuncionario(f);
		List<Funcionario> funcionarios = loja.getFuncioniarios();
		assertEquals(1,funcionarios.size());		
	}

	@Test
	void testBuscarFuncionario() throws FuncionarioJaExistenteException, FuncionarioNaoExistenteException {
		Funcionario f = criarFuncionarioPadrao();
		loja.addFuncionario(f);
		assertEquals(f,loja.buscarFuncionario(f.getCpf()));
		
	}

	@Test
	void testMostrarFuncionariosComGratificacao() throws FuncionarioJaExistenteException {
		Funcionario f = criarFuncionarioPadrao();
		f.setGratificacao(500);
		loja.addFuncionario(f);
		List<Funcionario> fs = loja.getFuncioniarios();
		assertEquals(f,fs.get(0));
				
	}

	@Test
	void testAddProdutos() throws ProdutoJaExistenteException {
		Produto p = criarProdutoPadrao();
		loja.addProdutos(p);
		List<Produto> produtos = loja.getProdutos();
		assertEquals(1,produtos.size());
	}

	@Test
	void testBuscarProdutoPorCodigo() throws ProdutoJaExistenteException, ProdutoNaoExistenteException {
		Produto p = criarProdutoPadrao();
		loja.addProdutos(p);
		assertEquals(p,loja.buscarProdutoPorCodigo(p.getCodigo()));
		
	}

	@Test
	void testRemoverProduto() throws ProdutoJaExistenteException, ProdutoNaoExistenteException {
		Produto p = criarProdutoPadrao();
		List<Produto> produtos = loja.getProdutos();
		loja.removerProduto(p);		
		assertEquals(0,produtos.size());
		
	}

	@Test
	void testBuscarProdutoPorCategoria() throws ProdutoJaExistenteException, ProdutoNaoExistenteException {
		Produto p = criarProdutoPadrao();
		loja.addProdutos(p);
		List<Produto> produtos = loja.buscarProdutoPorCategoria(p.getCategoria());
		assertEquals(1,produtos.size());
		
	}

	@Test
	void testTotalEstoque() throws ProdutoJaExistenteException {
		Produto p = criarProdutoPadrao();
		loja.addProdutos(p);
		assertEquals(50,loja.totalEstoque());
		
	}
	
	private Funcionario criarFuncionarioPadrao() {
		Funcionario f = new Funcionario();
		f.setNome("Lucas Pessoa Alves");
		f.setCpf("1234");
		f.setSalario(1500.000);
		f.setGratificacao(500.000);
		
		return f;
	}

	
	private Produto criarProdutoPadrao() {
		Produto p = new Produto();
		p.setNome("Camisa Polo xx");
		p.setCodigo("231");
		p.setCategoria("camisa");
		p.setPreco(50);
		
		return p;
		
	}
	
	private Cliente criarClientePadrao() {
		Cliente c = new Cliente();
		c.setNome("Livia Pessoa Alves");
		c.setCpf("54321");
		return c;
		
	}
}
