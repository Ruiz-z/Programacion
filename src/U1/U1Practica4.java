package U1;

import javax.swing.JOptionPane;

public class U1Practica4 {

	public static void main(String[] args) {
		int opcion;
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(
					"Menú:\n1. Generar Matriz A\n2. Generar Matriz B (Triangular Superior)\n3. Terminar"));

			switch (opcion) {
			case 1:
				int nA = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el valor de n para la Matriz A:"));
				generarMatrizA(nA);
				break;
			case 2:
				int nB = Integer.parseInt(
						JOptionPane.showInputDialog("Ingrese el valor de n para la Matriz B (Triangular Superior):"));
				generarMatrizB(nB);
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Programa terminado.");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
				break;
			}
		} while (opcion != 3);
	}

	public static void generarMatrizA(int n) {
		int[][] matrizA = new int[n][n];
		int contador = 1;

		int filaInicio = 0;
		int filaFin = n - 1;

		while (filaInicio <= filaFin) {
			for (int j = 0; j < n; j++) {
				matrizA[filaInicio][j] = contador++;
			}

			if (filaInicio != filaFin) {
				for (int j = 0; j < n; j++) {
					matrizA[filaFin][j] = contador++;
				}
			}

			filaInicio++;
			filaFin--;
		}

		imprimirMatriz(matrizA, "Matriz A:");
	}

	public static void generarMatrizB(int n) {
		int[][] matrizB = new int[n][n];
		int contador = 1;

		for (int i = 0; i < n; i++) {
			int fila = i;
			int columna = n - 1 - i;

			for (int j = 0; j <= columna; j++) {
				matrizB[fila][j] = contador++;
				fila++;
			}
		}

		imprimirMatriz1(matrizB, "Matriz B (Triangular Superior):");
	}

	public static void imprimirMatriz(int[][] matriz, String titulo) {
		StringBuilder sb = new StringBuilder();
		sb.append(titulo).append("\n");

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				sb.append(matriz[i][j]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		JOptionPane.showMessageDialog(null, sb.toString());
	}

	public static void imprimirMatriz1(int[][] matriz, String titulo) {
		StringBuilder sb = new StringBuilder();
		sb.append(titulo).append("\n");

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				sb.append(matriz[j][i]);
				sb.append(" ");
			}
			sb.append("\n");
		}
		JOptionPane.showMessageDialog(null, sb.toString());
	}
}
