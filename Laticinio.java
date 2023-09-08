package Supermercado;

public class Laticinio extends Produto {
	private String tipoCalorico;
	private String tipoLaticinio;

	public Laticinio (String nome, String codigo, String fornecedor,
			String tipoC, String tipoL){
		super (codigo, fornecedor, nome, "Latic�nio");
		this.tipoCalorico  = tipoC;
		this.tipoLaticinio = tipoL;
	}

	public String getTipoCalorico() {
		return tipoCalorico;
	}

	public void setTipoCalorico(String tipoCalorico) {
		this.tipoCalorico = tipoCalorico;
	}

	public String getTipoLaticinio() {
		return tipoLaticinio;
	}

	public void setTipoLaticinio(String tipoLaticinio) {
		this.tipoLaticinio = tipoLaticinio;
	}

	public String toString () {
		return  super.toString() + 
				"Tipo Latic�nio: " + this.getTipoLaticinio() + "\n" +
				"Tipo Cal�rico: " + this.getTipoCalorico();
	}


}
