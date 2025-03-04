package U3;

import javax.swing.JOptionPane;

public class U3Practica5 {
public static ColaCircularString alumnos = new ColaCircularString(20);
public static ColaCircularString trabajador = new ColaCircularString(20);
	public static void main(String[] args){
			Object[] opciones = {"1.-Formar Alumno",
					"2.-Formar Trabajador",
					"3.-Atiende",
					"4.-Terminar"};
	String tipo = "";
	do {
		tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
				null, opciones, opciones[0]);
		if (tipo == null) {
			tipo = "4.- Terminar";
		}
		switch (tipo) {

		case "1.-Formar Alumno":
			String nombre = JOptionPane.showInputDialog("Ingrese nombre");
			alumnos.insertar(nombre);
			break;


		case "2.-Formar Trabajador":
		String nombTra= JOptionPane.showInputDialog("Ingrese nombre");
		trabajador.insertar(nombTra);
			break;
		case "3.-Atiende":
			if(!trabajador.estaVacia()) {
				
				JOptionPane.showMessageDialog(null, "Trabajador: "+trabajador.eliminar());
				}else { 
					JOptionPane.showMessageDialog(null, "Alumno"+alumnos.eliminar());
			}
			break;
		case "4.-Terminar":
			
			break;
		
		}
	}while(tipo!="4.-Terminar");
	

	}
	
	}


