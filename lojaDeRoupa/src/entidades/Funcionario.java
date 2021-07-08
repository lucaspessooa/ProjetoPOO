package entidades;

public class Funcionario extends Pessoa {
	private double salario;
	private double gratificacao;
	private int totalVendas;
	
	
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public double getGratificacao() {
		return gratificacao;
	}
	public void setGratificacao(double gratificacao) {
		this.gratificacao = this.calcularGratificacao();
	}
	public int getTotalVendas() {
		return totalVendas;
	}
	public void setTotalVendas(int totalVendas) {
		this.totalVendas = totalVendas;
	}
	
	public double calcularGratificacao() {
		double total = this.getGratificacao();
		if(getTotalVendas() > 20) {
			total = getSalario()*2;
		}
		return total;
	}

}
