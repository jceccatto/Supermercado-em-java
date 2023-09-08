package Supermercado;

public class Limpeza extends Produto{
	private String tipoLimpeza;

	public Limpeza (String nome, String codigo, String fornecedor, String tipoL)	{
		super (codigo, fornecedor, nome, "Limpeza");
		this.tipoLimpeza = tipoL;
	}

	public String getTipoLimpeza() {
		return tipoLimpeza;
	}

	public void setTipoLimpeza(String tipoLimpeza) {
		this.tipoLimpeza = tipoLimpeza;
	}

	public String toString () {
		return super.toString() +
				"Tipo Material Limpeza: " + this.getTipoLimpeza();
	}


}
