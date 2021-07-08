package controles;

import java.util.ArrayList;
import java.util.List;

import entidades.Produto;
import exception.ProdutoJaExistenteException;
import exception.ProdutoNaoExistenteException;

public class GerenteDeProduto {

	private List<Produto> produtos = new ArrayList<Produto>();

	public void addProdutos(Produto p) throws ProdutoJaExistenteException {
		for (Produto p1 : produtos) {
			if (p1.getCodigo().equalsIgnoreCase(p.getCodigo())) {
				throw new ProdutoJaExistenteException();
			}
		}
		this.produtos.add(p);

	}
	
	public List<Produto> getProdutos(){
		return produtos;
	}

	public Produto buscarProdutoPorCodigo(String codigo) throws ProdutoNaoExistenteException {
		for (Produto p : this.produtos) {
			if (p.getCodigo().equalsIgnoreCase(codigo)) {
				return p;
			}
		}
		throw new ProdutoNaoExistenteException();
	}

	public void removerProduto(Produto p) throws ProdutoNaoExistenteException {
		for (Produto p1 : produtos) {
			if (p1.getCodigo().equalsIgnoreCase(p.getCodigo())) {
				throw new ProdutoNaoExistenteException();
			}
		}
		this.produtos.remove(p);
	}

	public List<Produto> buscarProdutoPorCategoria(String categoria) throws ProdutoNaoExistenteException {
		List<Produto> p = new ArrayList<Produto>();
		for (Produto p1 : this.produtos) {
			if (p1.getCategoria().equalsIgnoreCase(categoria)) {
				p.add(p1);
			}
		}
		if (p.size() > 0) {
			return p;
		}
		throw new ProdutoNaoExistenteException();

	}
	
	public double totalEstoque() {
		double total = 0.0;
		for(Produto p: produtos) {
			total+=p.getPreco();
		}
		return total;
	}
	
	
	
}
