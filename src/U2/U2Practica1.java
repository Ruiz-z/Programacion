package U2;

	import javax.swing.JOptionPane;

	public class U2Practica1 {
	    public static void main(String[] args) {
	        Object[] opciones = { "1.- Leer expresion matematica", "2.- Salir"};
			String tipo = "";
			do {
				tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
						null, opciones, opciones[0]);
				if (tipo == null) {
					tipo = "Salir";
				}
				switch (tipo) {
				case "1.- Leer expresion matematica":
					String expresion = JOptionPane.showInputDialog("Ingrese una expresion matematica");
					esExpresionValida(expresion);
					if (esExpresionValida(expresion)) {
			            JOptionPane.showMessageDialog(null,"La expresión es válida.");
			        } else {
			        	 JOptionPane.showMessageDialog(null,"La expresión es inválida.");
			        }
				case "2.- Salir":
					break;
				}
			} while (!tipo.equals("2.- Salir"));
		}
	    

	    // Método para verificar si una expresión es válida
	    public static boolean esExpresionValida(String expresion) {
	        PilaChar pila = new PilaChar(expresion.length());

	        for (char caracter : expresion.toCharArray()) {
	            if (caracter == '(' || caracter == '{' || caracter == '[') {
	                pila.push(caracter);
	            } else if (caracter == ')' || caracter == '}' || caracter == ']') {
	                if (pila.isEmpty()) {
	                    return false; // Falta un paréntesis de apertura
	                }

	                char caracterPop = pila.pop();
	                if (!esParValido(caracterPop, caracter)) {
	                    return false; // Los paréntesis no coinciden en orden
	                }
	            }
	        }

	        return pila.isEmpty(); // La pila debe estar vacía al final
	    }

	    // Método para verificar si un par de paréntesis es válido
	    public static boolean esParValido(char apertura, char cierre) {
	        return (apertura == '(' && cierre == ')') ||
	               (apertura == '{' && cierre == '}') ||
	               (apertura == '[' && cierre == ']');
	    }
	}


