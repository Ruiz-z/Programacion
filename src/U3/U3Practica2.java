package U3;

import java.util.StringTokenizer;

import javax.swing.JOptionPane;

public class U3Practica2 {
public static ColaString corta = new ColaString(100);
public static ColaString larga = new ColaString(100);

public static void main(String[] args){
	Object[] opciones = { "1.- Leer una palabra", "2.- Mostrar palabras cortas",
		"3.- Mostrar palabras largas", "4.-Buscar palabras ","5.- Terminar" };
String tipo = "";

do {
	tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
			null, opciones, opciones[0]);
	if (tipo == null) {
		tipo = "8.- Terminar";
	}

	switch (tipo) {

	case "1.- Leer una palabra":
        InsertarFrase();
		break;


	case "2.- Mostrar palabras cortas":
		JOptionPane.showMessageDialog(null, corta.toString());
   
		break;

	case "3.- Mostrar palabraslargas":
		JOptionPane.showMessageDialog(null, larga.toString());
		break;
	case "4.- Buscar palabras":

    
		break;

	case "5.- Terminar":

		break;

	}
} while (tipo!="8.- Terminar");
}

public static void InsertarFrase() {
	String frase = JOptionPane.showInputDialog("Ingrese una frase minimo de 30 palabras");
	if(frase.length() >= 30) {
		StringTokenizer st = new StringTokenizer(frase);
		while(st.hasMoreTokens()) {
			String palabra = st.nextToken();
			if(palabra.length()<=4) {
			corta.insertar(palabra);
			}else {
				larga.insertar(palabra);
			}
		}}
	}
	   
	  
	  
	   


public static void BuscarPalabra() {
	String buscarPalabra = JOptionPane.showInputDialog("Ingrese la palabra a buscar");

	if(corta.Buscar(buscarPalabra)==true) {
		JOptionPane.showMessageDialog(null, "La palabra fue encontrada en palabras cortas: "+buscarPalabra);
		
	}else {
		JOptionPane.showMessageDialog(null,"La palabra no fue encontrada en la palabras cortas, procediendo a buscar en palabras largas");
		if(larga.Buscar(buscarPalabra)==true) {
			JOptionPane.showMessageDialog(null, "La palabra fue encontrada en palabras largas: "+buscarPalabra);
		}else {
			JOptionPane.showMessageDialog(null,"La palabra no fue encontrada en palabras largas");
		}
	}

}
}

