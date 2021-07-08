package loja;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entidades.Cliente;
import entidades.Funcionario;
import entidades.Pessoa;
import entidades.Produto;
import exception.ClienteJaExistenteException;
import exception.FuncionarioJaExistenteException;
import exception.ProdutoJaExistenteException;
import exception.ProdutoNaoExistenteException;
import fachada.LojaDeRoupaFacade;

public class Loja {

	public static void main(String[] args) {
		LojaDeRoupaFacade loja = new LojaDeRoupaFacade();

		boolean sair = false;
		while (!sair) {
			int opcao = Integer.parseInt(
					JOptionPane.showInputDialog("Digite uma opção:\n1.Cadastrar cliente\n" + "2.Cadastrar produto\n"
							+ "3.Cadastrar Funcionário\n" + "4.Remover Produto\n" + "5.Buscar produto por categoria"
							+ "\n6. Pesquisar Produto" + "\n7. Mostrar Funcionários com gratificação"
							+ "\n8.Pesquisar Montate de Estoque" + "\n9.Sair\n"));

			switch (opcao) {
			case 1: {
				String nome = JOptionPane.showInputDialog("Qual o nome do cliente?");
				String cpf = JOptionPane.showInputDialog("Qual o cpf do cliente?");
				Cliente cliente = new Cliente();
				cliente.setNome(nome);
				cliente.setCpf(cpf);
				try {
					loja.addCliente(cliente);
					JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
				} catch (ClienteJaExistenteException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Cliente já cadastrado. Tente novamente");
				}
				break;

			}
			case 2: {
				String nome = JOptionPane.showInputDialog("Qual o nome do Produto?");
				String codigo = JOptionPane.showInputDialog("Qual o código do Produto?");
				String categoria = JOptionPane.showInputDialog("Qual a categoria do Produto?");
				String preco1 = JOptionPane.showInputDialog("Qual o preço do Produto?");
				double preco = Double.parseDouble(preco1);
				Produto produto = new Produto();
				produto.setNome(nome);
				produto.setCodigo(codigo);
				produto.setCategoria(categoria);
				produto.setPreco(preco);
				try {
					loja.addProdutos(produto);
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
					String pergunta = JOptionPane.showInputDialog("Deseja salvar o produto?");
					if(pergunta.equalsIgnoreCase("sim")) {
						List <String> produtos = new ArrayList<String>();
						produtos.add(nome);
						produtos.add(codigo);
						produtos.add(categoria);
						produtos.add(preco1);
						try {
							loja.gravarProduto(produtos, "produtos.txt");	
							JOptionPane.showMessageDialog(null,"Produto salvo com sucesso");
						}catch(IOException e) {
							JOptionPane.showMessageDialog(null, e.getMessage());
						}
						
					}
				} catch (ProdutoJaExistenteException e) {
					JOptionPane.showMessageDialog(null, "Produto já cadastrado. Tente novamente");
					e.printStackTrace();
				}
				break;
			}
			case 3: {
				String nome = JOptionPane.showInputDialog("Qual o nome do Funcionario?");
				String cpf = JOptionPane.showInputDialog("Qual o cpf do Funcionario?");
				double salario = Double.parseDouble(JOptionPane.showInputDialog("Qual o salario do Funcionario?"));
				Funcionario f = new Funcionario();
				f.setNome(nome);
				f.setCpf(cpf);
				f.setSalario(salario);
				try {
					loja.addFuncionario(f);
					JOptionPane.showMessageDialog(null, "Funcionário Cadastro com sucesso");
				} catch (FuncionarioJaExistenteException e) {
					JOptionPane.showMessageDialog(null, "Funcinário já cadastrado. Tente novamente");
					e.printStackTrace();
					break;
				}
			}
			case 4: {
				String codigo = JOptionPane.showInputDialog("Qual o código do produto que deseja remover?");
				Produto p = new Produto();
				p.setCodigo(codigo);
				try {
					loja.removerProduto(p);
					JOptionPane.showMessageDialog(null, "Produto removido com sucesso");
				} catch (ProdutoNaoExistenteException e) {
					JOptionPane.showMessageDialog(null, "Produto não encontrado. Tente novamente");
					e.printStackTrace();
				}
				break;
			}
			case 5: {
				String categoria = JOptionPane.showInputDialog("Informe a categoria do produto");
				try {
					List<Produto> produtos = new ArrayList<Produto>();
					produtos = loja.buscarProdutoPorCategoria(categoria);
					for (Produto p : produtos) {
						JOptionPane.showMessageDialog(null, p.getNome());

					}

				} catch (ProdutoNaoExistenteException e) {
					JOptionPane.showMessageDialog(null, "Produto não encontrado. Tente novamente");
					e.printStackTrace();
				}
				break;
			}
			case 6: {
				String codigo = JOptionPane.showInputDialog("Informe o código do produto");
				try {
					Produto p = new Produto();
					p = loja.buscarProdutoPorCodigo(codigo);
					JOptionPane.showMessageDialog(null, p);

				} catch (ProdutoNaoExistenteException e) {
					JOptionPane.showMessageDialog(null, "Produto não encontrado. Tente novamente");
					e.printStackTrace();
				}
				break;
			}
			case 7: {
				List<Funcionario> funcionarios = new ArrayList<Funcionario>();
				funcionarios = loja.mostrarFuncionariosComGratificacao();
				for (Funcionario f : funcionarios) {
					JOptionPane.showMessageDialog(null, f.getNome());

				}
				break;
			}
			case 8:{
				double total = loja.totalEstoque();
				JOptionPane.showMessageDialog(null, total);				
				break;
			}
			
			case 9:{
				sair = true;
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
		}

	}

}
