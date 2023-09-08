package Supermercado;

import java.io.Serializable;

public class Produto implements Serializable  {
 
	private String codigo;
	private String fornecedor;
	private String nome;
	private String categoria;
	 
	public Produto (String codigo, String fornecedor, String nome, String categoria)
	{
		this.codigo = codigo;
		this.fornecedor = fornecedor;
		this.nome = nome;
		this.categoria = categoria;
	}
	
	public Produto ()
	{
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public String toString () {
		String retorno;
		
		retorno = "--------------------------" + 
			      "Categoria: " + this.getCategoria() +  
				  "--------------------------\n" +
				  "Nome: " + this.getNome() +  "\n" +
				  "Codigo: " + this.getCodigo() + "\n" +
		          "Fornecedor:  " + this.getFornecedor() + "\n";
		          
	
		return retorno;
	}

}
