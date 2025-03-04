package U1;

import javax.swing.JOptionPane;

public class U1Practica3 {

	static int c[][];
	static int d[][];
	static String salida = "";
	static int suma;
	static int ctrans[][];
	static int vsumas[][];

	public static void MatrizTranspuesta(int n) {
		c = new int[n][(2 * n)];
		ctrans = new int[2 * n][(n)];
		for (int x = 0; x < c.length; x++) {
			for (int y = 0; y < c[x].length; y++) {
				c[x][y] = (int) (Math.random() * 100 );
			}
		}
		for (int x = 0; x < ctrans.length; x++) {
			for (int y = 0; y < ctrans[x].length; y++) {
				ctrans[x][y] = c[y][x];
			}
		}
		salida += "Datos de la matriz:\n";
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				salida += "| " + c[i][j];
			}
			salida += "|\n";
		}
		salida += "\n\nDatos de la matriz transpuesta:\n";
		for (int i = 0; i < (ctrans.length); i++) {
			for (int j = 0; j < (ctrans[i].length); j++) {
				salida += "| " + ctrans[i][j];
			}
			salida += "|\n";
		}
		JOptionPane.showMessageDialog(null, salida);
		salida = "";
	}

	public static void SumaColumnas(int n) {
		d = new int[n][(2 * n)];
		vsumas = new int[2 * n][(n)];
		for (int x = 0; x < d.length; x++) {
			for (int y = 0; y < d[x].length; y++) {
				d[x][y] = (int) (Math.random() * 100);
			}
		}
		salida += "Datos de la matriz:\n";
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d[i].length; j++) {
				salida += "| " + d[i][j];
			}
			salida += "|\n";
		}
		salida += "\n\nSuma de la matriz:\n";
		for (int x = 0; x < d[0].length; x++) {
	        int suma= 0;
	        salida += "| ";
	        for (int y = 0; y < d.length; y++) {
	        	
	            suma += d[y][x];
	        }
	        salida +=suma+ "| ";
		}
		JOptionPane.showMessageDialog(null, salida);
		salida = "";
	}

	public static void main(String[] args) {
		Object[] opciones = { "1.- Matriz transpuesta", "2.- Suma de columnas", "3.- Terminar" };
		String tipo = "";
		do {
			tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);
			if (tipo == null) {
				tipo = "Terminar";
			}
			switch (tipo) {
			case "1.- Matriz transpuesta":
				int nA = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de n para la Matriz:"));
				try {
					do {
						if (nA <= 0) {
							JOptionPane.showMessageDialog(null,
									"Ingrese un numero valido para la creacion de la matriz: ");
						}
					} while (nA <= 0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Solo numeros enteros");

				}
				MatrizTranspuesta(nA);
				break;
			case "2.- Suma de columnas":
				int nB = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de n para la Matriz:"));
				try {
					do {
						if (nB <= 0) {
							JOptionPane.showMessageDialog(null,
									"Ingrese un numero valido para la creacion de la matriz: ");
						}
					} while (nB <= 0);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Solo numeros enteros");

				}
				SumaColumnas(nB);
				break;
			case "3.- Terminar":
				break;
			}
		} while (tipo != "3.- Terminar");
	}

}
