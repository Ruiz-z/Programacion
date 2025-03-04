package U1;

import javax.swing.JOptionPane;

import utilidades.SalidaFor;



public class Examen_U1 {
	static Equipo[] equipos = new Equipo[8];
	static int numEquipos=0;
	 static String salida = "";
	public static void CapturaEquipo(){
	 try {
		if(numEquipos<=equipos.length) {
			String nombre = JOptionPane.showInputDialog("Ingrese el nombre del equipo");
			int division = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la division del equipo"));
			int puntos = Integer.parseInt(JOptionPane.showInputDialog("Ingrese los puntos del equipo"));
			
			equipos[numEquipos] = new Equipo(nombre, division, puntos);
			numEquipos++;
		}
	 }catch(ArrayIndexOutOfBoundsException e) {
		 JOptionPane.showMessageDialog(null,"El EQUIPO NO PUEDE AGREGARSE");
	 } 
	
	}
	public static void MostrarEquipo() {
		StringBuilder datos = new StringBuilder("Datos de los equipos:\n");
		for (int i = 0; i < numEquipos; i++) {
			datos.append(equipos[i].toString()).append("\n");
		}
		salida=datos.toString();
		System.out.println(salida);
		
	}
	static int puntos=0;
	public static void EqPuntos() {
		StringBuilder datos = new StringBuilder("Datos de los equipos:\n");
		 for (int i = 0; i < numEquipos; i++) {
			 if( puntos<equipos[i].getPuntos()) {
			System.out.println(datos.append(equipos[i].toString()));
		}
			}}
	
	public static void main(String[] args) {
		Object[] opciones = { "1.- Captura de un equipo", "2.- Mostrar datos de equipos", "3.- Equipo con mas puntos",
				"4.- Manjeo de una matriz", "5.- Salir" };
		String tipo = "";
		do {
			tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);
			if (tipo == null) {
				tipo = "Salir";
			}
			switch (tipo) {
			case "1.- Captura de un equipo":
				CapturaEquipo();
				break;
			case "2.- Mostrar datos de un equipo":
				MostrarEquipo();
				break;
			case "3.- Equipo con mas puntos":
				EqPuntos();
				break;
			case "4.- Manejo de una matriz":
			
				break;
			case "5.- Salir":
				break;
			}
		} while (!tipo.equals("5.- Salir"));
	}
	}


