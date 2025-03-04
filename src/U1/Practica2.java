package U1;

import javax.swing.JOptionPane;

import utilidades.SalidaFor;

public class Practica2 {
	static Alumno[] grupoB = new Alumno[7];
	static int numAlumnos = 0;
	static String salida = "";

	public static void CreacionAlumno() {
		try {
		if (numAlumnos < grupoB.length) {
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno");
			int numCtrl = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de control"));
			int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del alumno"));
			float calif[] = new float[3];
			for (int i = 0; i < calif.length; i++){
				calif[i] = Float.parseFloat(JOptionPane.showInputDialog("Ingrese la calificacion"));
			}
			grupoB[numAlumnos] = new Alumno(nombre, numCtrl, edad, calif);
			numAlumnos++;
		}
		}catch(ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null,"ALUMNO NO PUEDE AGREGARSE AL GRUPO");
		}
	}

	public static void MostrarAlumno() {
		StringBuilder datos = new StringBuilder("Datos de los alumnos:\n");
		for (int i = 0; i < numAlumnos; i++) {
			datos.append(grupoB[i].toString()).append("\n");
		}
		salida = datos.toString();
		SalidaFor.imprimerConScroll(salida);
	}

	public static void mostrarPromedioGrupo() {
		float totalPromedio = 0;
		for (int i = 0; i < numAlumnos; i++) {
			totalPromedio += grupoB[i].calcularPromedio();
		}
		float promedioGrupo = totalPromedio / numAlumnos;
		salida = "Promedio del grupo: " + promedioGrupo;
		SalidaFor.imprimerConScroll(salida);
	}

	public static void aumentarPuntos() {
		String nombre = JOptionPane.showInputDialog("Ingrese el nombre del alumno");
		int puntos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de puntos a aumentar"));
		for (int i = 0; i < numAlumnos; i++) {
			if (grupoB[i].getNombre().equalsIgnoreCase(nombre)) {
				grupoB[i].aumentarCalif(puntos);
				JOptionPane.showMessageDialog(null, "Puntos aumentados correctamente.");
				return;
			} else {
				JOptionPane.showMessageDialog(null, "Alumno no encontrado.");
			}
		}
	}

	public static void main(String[] args) {
		Object[] opciones = { "1.- Capturar un alumno", "2.- Mostrar datos de un alumno", "3.- Promedio del grupo",
				"4.- Aumentar puntos", "5.- Salir" };
		String tipo = "";
		do {
			tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);
			if (tipo == null) {
				tipo = "Salir";
			}
			switch (tipo) {
			case "1.- Capturar un alumno":
				CreacionAlumno();
				break;
			case "2.- Mostrar datos de un alumno":
				MostrarAlumno();
				break;
			case "3.- Promedio del grupo":
				mostrarPromedioGrupo();
				break;
			case "4.- Aumentar puntos":
				aumentarPuntos();
				break;
			case "5.- Salir":
				break;
			}
		} while (!tipo.equals("5.- Salir"));
	}
}

