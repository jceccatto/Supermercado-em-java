package Supermercado;

public class Bebida extends Produto {
	private String tipoBebida;
	
	public Bebida (String nome, String codigo, String fornecedor, String tipoB)	{
		super (codigo, fornecedor, nome, "Bebida");
		this.tipoBebida = tipoB;
	}

	public String getTipoBebida() {
		return this.tipoBebida;
	}
	 
	public void setTipoBebida(String tipo) {
		this.tipoBebida = tipo;
	}
	 
	public String toString (){	
		return super.toString() + "Tipo Bebida: " + this.getTipoBebida();
	}
	
}
