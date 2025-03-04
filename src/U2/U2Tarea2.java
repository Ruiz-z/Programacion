package U2;

import javax.swing.JOptionPane;
import utilidades.SalidaFor;
public class U2Tarea2 {

	public static void main(String[] args) {
		
		
		Object[] opciones = { "1.- Leer un enunciado", "2.- Mostrar pila de letras", "3.- Mostrar pila de dígitos",
				"4.- Mostrar pila de signos", "5.- Salir" };
		String tipo = "";
		do {
			tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);
			if (tipo == null) {
				tipo = "Salir";
			}
			switch (tipo) {
			case "1.- Leer un enunciado":
				String palabra = JOptionPane.showInputDialog("Ingrese la palabra");
				LeerEnunciado(palabra);
				break;
			case "2.- Mostrar pila de letras":
				MostrarPilaLetras();
				break;
			case "3.- Mostrar pila de dígitos":
				MostrarPilaDigitos();
				break;
			case "4.- Mostrar pila de signos":
				MostrarPilaSimbolos();
				break;
			case "5.- Salir":
				break;
			}
		} while (!tipo.equals("5.- Salir"));
	}
	static String palabra;
	static String salida;
	static PilaChar pilaLetras;
	static PilaChar pilaDigitos;
	static PilaChar pilaSimbolos;
	public static void LeerEnunciado(String palabra) {
		JOptionPane.showMessageDialog(null, "Tu palabra es: " + palabra);
		salida = 	"";
		pilaLetras = new PilaChar(palabra.length());
		pilaDigitos = new PilaChar(palabra.length());
		pilaSimbolos = new PilaChar(palabra.length());
		for (int i = 0; i < palabra.length(); i++) {
			char caracter = palabra.charAt(i);
			if (Character.isLetter(caracter)) {
				pilaLetras.push(caracter);
			} else {
				if (Character.isDigit(caracter)) {
					pilaDigitos.push(caracter);
				} else {
					pilaSimbolos.push(caracter);
				}
			}
		}
	}
	public static void MostrarPilaLetras() {
		salida+="Datos de la pila de letras:\n";
		salida+=pilaLetras.toString()+"\n";
		SalidaFor.imprimerConScroll(salida);
	}
	
	public static void MostrarPilaDigitos() {
		salida+="Datos de la pila de digitos:\n";
		salida+=pilaDigitos.toString()+"\n";
		SalidaFor.imprimerConScroll(salida);
	}
	public static void MostrarPilaSimbolos() {
		salida+="Datos de la pila de simbolos:\n";
		salida+=pilaSimbolos.toString()+"\n";
		SalidaFor.imprimerConScroll(salida);
	}
}

