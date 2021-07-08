package entidades;

public class Cliente extends Pessoa {
	
	private double pagamento;
	private String tipoDePagamento;
	
	public double getPagamento() {
		return pagamento;
	}
	public void setPagamento(double pagamento) {
		this.pagamento = pagamento;
	}
	public String getTipoDePagamento() {
		return tipoDePagamento;
	}
	public void setTipoDePagamento(String tipoDePagamento) {
		this.tipoDePagamento = tipoDePagamento;
	}
	

}
