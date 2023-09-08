package Supermercado;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Supermercado {
	
	public String[] leValores (String [] dadosIn){
		String [] dadosOut = new String [dadosIn.length];

		for (int i = 0; i < dadosIn.length; i++)
			dadosOut[i] = JOptionPane.showInputDialog  ("Entre com " + dadosIn[i]+ ": ");

		return dadosOut;
	}

	public Laticinio leLaticinio (){

		String [] valores = new String [5];
		String [] nomeVal = {"Nome", "Codigo", "Fornecedor", "Tipo Calorico", "Tipo Laticínio"};
		valores = leValores (nomeVal);

		Laticinio prodLat = new Laticinio (valores[0],valores[1],valores[2],
				valores[3],valores[4]);
		return prodLat;
	}

	public Limpeza leLimpeza (){

		String [] valores = new String [4];
		String [] nomeVal = {"Nome", "Codigo", "Fornecedor", "Tipo Limpeza" };
		valores = leValores (nomeVal);

		Limpeza prodLimp = new Limpeza (valores[0],valores[1],valores[2], valores[3]);
		return prodLimp;
	}

	public Bebida leBebida (){

		String [] valores = new String [4];
		String [] nomeVal = {"Nome", "Codigo", "Fornecedor", "Tipo Bebida" };
		valores = leValores (nomeVal);

		Bebida prodBeb = new Bebida (valores[0],valores[1],valores[2], valores[3]);
		return prodBeb;
	}


	public void mostraProduto (String dados){
		JOptionPane.showMessageDialog(null,"PRODUTO\n-------\n +" +dados);		
	}

	public void salvaProdutos (ArrayList<Produto> produtos){
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream 
					(new FileOutputStream("c:\\temp\\superMercado.dad"));
			for (int i=0; i < produtos.size(); i++)
				outputStream.writeObject(produtos.get(i));
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Impossível criar arquivo!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectOutputStream
			try {
				if (outputStream != null) {
					outputStream.flush();
					outputStream.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	@SuppressWarnings("finally")
	public ArrayList<Produto> recuperaProdutos (){
		ArrayList<Produto> produtos = new ArrayList<Produto>();

		ObjectInputStream inputStream = null;

		try {	
			inputStream = new ObjectInputStream
					(new FileInputStream("c:\\temp\\superMercado.dad"));
			Object obj = null;
			while ((obj = inputStream.readObject()) != null) {
				if (obj instanceof Produto) {
					produtos.add((Produto) obj);
				}   
			}          
		} catch (EOFException ex) { // when EOF is reached
			System.out.println("End of file reached.");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		} catch (FileNotFoundException ex) {
			JOptionPane.showMessageDialog(null,"Arquivo com produtos NÃO existe!");
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {  //Close the ObjectInputStream
			try {
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
			return produtos;
		}
	}

	public void menuProdutos (){

		ArrayList<Produto> produtos = new ArrayList<Produto>();


		String menu = "";
		String entrada;
		int    opc1, opc2;

		do {
			menu = "Controle Supermercado\n" +
					"Opções:\n" + 
					"1. Entrar Produtos\n" +
					"2. Exibir Produtos\n" +
					"3. Limpar Produtos\n" +
					"4. Gravar Produtos\n" +
					"5. Recuperar Produtos\n" +
					"9. Sair";
			entrada = JOptionPane.showInputDialog (menu + "\n\n");
			
			while (!numeroInteiroValido(entrada)) {
	            entrada = JOptionPane.showInputDialog(null, menu + 
	                    "\n\nEntrada inválida! Digite um número inteiro.");
	        }
			opc1 = new Integer(entrada);

			switch (opc1) {
			case 1:// Entrar dados
				menu = "Entrada de Produto\n" +
						"Opções:\n" + 
						"1. Laticínio\n" +
						"2. Limpeza\n" +
						"3. Bebida\n";

				entrada = JOptionPane.showInputDialog (menu + "\n\n");
				while (!numeroInteiroValido(entrada)) {
		            entrada = JOptionPane.showInputDialog(null, menu + 
		                    "\n\nEntrada inválida! Digite um número inteiro.");
		        }
				opc2 = new Integer(entrada);

				switch (opc2){
				case 1: produtos.add((Produto)leLaticinio());
				break;
				case 2: produtos.add((Produto)leLimpeza());
				break;
				case 3: produtos.add((Produto)leBebida());
				break;
				default: 
					JOptionPane.showMessageDialog(null,"Produto para entrada NÃO escolhido!");
				}

				break;
			case 2: // Exibir dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com produtos primeiramente");
					break;
				}
				String dados = "";
				for (int i=0; i < produtos.size(); i++)	{
					dados += produtos.get(i).toString() + "\n";
				}
				JOptionPane.showMessageDialog(null,dados);
				break;
			case 3: // Limpar Dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com produtos primeiramente");
					break;
				}
				produtos.clear();
				JOptionPane.showMessageDialog(null,"Dados LIMPOS com sucesso!");
				break;
			case 4: // Grava Dados
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Entre com produtos primeiramente");
					break;
				}
				salvaProdutos(produtos);
				JOptionPane.showMessageDialog(null,"Dados SALVOS com sucesso!");
				break;
			case 5: // Recupera Dados
				produtos = recuperaProdutos();
				if (produtos.size() == 0) {
					JOptionPane.showMessageDialog(null,"Sem dados para apresentar.");
					break;
				}
				JOptionPane.showMessageDialog(null,"Dados RECUPERADOS com sucesso!");
				break;
			case 9:
				JOptionPane.showMessageDialog(null,"Fim do aplicativo SUEPERMERCADO");
				break;
			}
		} while (opc1 != 9);
	}
	
    private boolean numeroInteiroValido(String s) {
        boolean resultado;
        try {
            Integer.parseInt(s);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        }
        return resultado;
    }


	public static void main (String [] args){

		Supermercado sp = new Supermercado ();

		sp.menuProdutos();

	}



}


