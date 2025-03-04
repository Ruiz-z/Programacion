package U1;

import javax.swing.JOptionPane;

public class U1Tarea2robe {

	public static void main(String[] args) {
		int totalOpciones;
		String menu = "";
		menu += "1.Capturar alumno \n";
		menu += "2.Mostrar datos del alumno \n";
		menu += "3.Promedio del grupo \n";
		menu += "4. Aumentar puntos \n";
		menu += "5.Terminar";
		totalOpciones = 5;

		Alumno[] grupoB = new Alumno[7]; // Create an array to store students
		int contador = 0; // Counter to keep track of the number of students added

		int opcion; // Declare the variable outside the loop

		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));

			switch (opcion) {
			case 1:
				if (contador < grupoB.length) {
					String n = JOptionPane.showInputDialog("nombre del alumno? ");
					int nC = Integer.parseInt(JOptionPane.showInputDialog("Numero de control ? "));
					int e = Integer.parseInt(JOptionPane.showInputDialog("edad del alumno ? "));
					float[] c = new float[3];
					for (int i = 0; i < c.length; i++) {
						c[i] = Float.parseFloat(JOptionPane.showInputDialog("capturar calificacion " + (i + 1) + ":"));
					}
					grupoB[contador] = new Alumno(n, nC, e, c);
					contador++;
				} else {
					JOptionPane.showMessageDialog(null, "ALUMNO NO PUEDE AGREGARSE AL GRUPO");
				}
				break;

			case 2:
				// Display data of all students in grupoB
				for (int i = 0; i < contador; i++) {
					JOptionPane.showMessageDialog(null,
							"Nombre: " + grupoB[i].getNombre() + "\nNúmero de Control: " + grupoB[i].getNumControl()
									+ "\nEdad: " + grupoB[i].getEdad() + "\nPromedio: " + grupoB[i].calcularPromedio());
				}
				break;

			case 3:
				// Calculate and display average of the group
				float totalPromedio = 0;
				for (int i = 0; i < contador; i++) {
					totalPromedio += grupoB[i].calcularPromedio();
				}
				float promedioGrupo = totalPromedio / contador;
				JOptionPane.showMessageDialog(null, "Promedio del grupo: " + promedioGrupo);
				break;

			case 4:
				String nombre = JOptionPane.showInputDialog("Nombre del alumno para aumentar puntos:");
				float puntosAumentar = Float.parseFloat(JOptionPane.showInputDialog("Cantidad de puntos a aumentar:"));
				boolean alumnoEncontrado = false;
				for (int i = 0; i < contador; i++) {
					if (grupoB[i].getNombre().equalsIgnoreCase(nombre)) {
						grupoB[i].aumentarCalif(puntosAumentar);
						alumnoEncontrado = true;
						break;
					}
				}
				if (!alumnoEncontrado) {
					JOptionPane.showMessageDialog(null, "Alumno no encontrado.");
				}
				break;

			case 5:
				JOptionPane.showMessageDialog(null, "Programa terminado.");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Opción inválida.");
				break;
			}
		} while (opcion != totalOpciones);
	}

}
