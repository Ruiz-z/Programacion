package U1;

import javax.swing.JOptionPane;

//a) Declarar y crear un vector (vPiram) para manejar 6 objetos (pirámides pentagonales regulares)
//b) Leer del teclado los datos necesarios (lado, altura y apotema de la base) para construir
//las figuras (objetos) de las casillas con índice impar (1, 3, etc.)
//c) Desplegar en pantalla los datos generales de las pirámides que están actualmente en el vector

//RUiz Alvarez Mauro Rodrigo
public class Practica1 {

	public static void main(String[] args) {
		PiramidePentagonal[] vPiram = new PiramidePentagonal[6];
		
		for (int i = 0; i < vPiram.length; i++) {
			if (i % 2 != 0) {
				float lado = Float
						.parseFloat(JOptionPane.showInputDialog(null, "Ingrese el tamaño del lado de la piramide: "));
				float altura = Float.parseFloat(
						JOptionPane.showInputDialog(null, "Ingrese el tamaño de la altura de la piramide: "));
				float apotemaB = Float.parseFloat(JOptionPane.showInputDialog(null,
						"Ingrese el tamaño de la apotema de la base de la piramide: "));
				
				PiramidePentagonal piramidePenta = new PiramidePentagonal(lado, altura, apotemaB);
				vPiram[i]=piramidePenta;
			}
		}
		String datos="";
		for(PiramidePentagonal elemento : vPiram) {
			if(elemento != null) {
				datos +=elemento+"\n";
			}	
		}
		JOptionPane.showMessageDialog(null, datos);
	}
}