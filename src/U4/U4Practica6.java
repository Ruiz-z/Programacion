package U4;

import javax.swing.JOptionPane;

public class U4Practica6 {

	public static void main(String[] args) {
		
ListaCircularDoctores turno1 = new ListaCircularDoctores();
ListaCircularDoctores turno2 = new ListaCircularDoctores();		
String nombre;
String especialidad;
String turnopcion;
float sueldo;



		Object[] opciones = { "1.- Dar de alta un medico en el Turno 1",
				"2.- Dar de alta un medico en el Turno 2",
				"3.- Mostrar medicos del primer turno",
				"4.- Mostrar medicos del segundo turno",
				"5.- Buscar un doctor",
				"6.- Ingresar alfabeticamente",
				"7.- Eliminar en una posicion",
				"8.- Terminar",
				"9.- Aumentar por posicion",
				"10.- Aumentar por Nombre",
				"11.- Aumentar todos los salarios",
				"12.- Doctor que mas gana",
				"13.- Eliminar el ultimo doctor",
				"14.- Eliminar por nombre"};
		
		Object[] opciones2 = { "Cardiología",
				"Pediatría",
				"Dermatología"};
		Object[] opciones3 = { "Turno 1",
				"Turno 2"};
		
		String tipo = "";
		
		do {
			tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);
			if (tipo == null) {
				tipo = "7.- Terminar";
			}


			switch (tipo) {
			case "1.- Dar de alta un medico en el Turno 1":
                nombre = JOptionPane.showInputDialog ("Nombre del doctor:");
                
        
                
                especialidad = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
    					null, opciones2, opciones2[0]);
                
             
                sueldo = Float.parseFloat (JOptionPane.showInputDialog ("Sueldo: "));
               
                
                turno1.insertarFinal(new NodoDoctor(new Doctor(nombre,especialidad,sueldo)));
                
                break;
                
			case "2.- Dar de alta un medico en el Turno 2":
                nombre = JOptionPane.showInputDialog ("Nombre del doctor:");
                
                especialidad = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
    					null, opciones2, opciones2[0]);
                
             
                sueldo = Float.parseFloat (JOptionPane.showInputDialog ("Sueldo: "));
               
                
                turno2.insertaInicio(new NodoDoctor(new Doctor(nombre,especialidad,sueldo)));
                
                break;
		
			case "3.- Mostrar medicos del primer turno":
				JOptionPane.showMessageDialog(null, "Turno 1: \n"+turno1.toString());
			break;
			
			case "4.- Mostrar medicos del segundo turno":
				JOptionPane.showMessageDialog(null, "Turno 2: \n"+turno2.toString());
			break;
			
			case "5.- Buscar un doctor":
				
				nombre = JOptionPane.showInputDialog("Nombre del doctor: ");
				if(turno1.listaVacia() && turno2.listaVacia()) {
					JOptionPane.showMessageDialog(null,"Listas vacías");
				}else {
					NodoDoctor encontrado = null;

                    boolean turno_1 = false;

					if(!turno1.listaVacia()) {
						if(turno1.Buscar(nombre)!=null){
                            encontrado = turno1.Buscar(nombre);
                            turno_1=true;
                        }
                        if(turno2.Buscar(nombre)!=null){
                            encontrado = turno2.Buscar(nombre);
                        }
					}
                    if(encontrado != null){
                        if(turno_1 = true){
                            JOptionPane.showMessageDialog(null,"Encontrado en el turno 2: \n"+encontrado.toString());
                        }

                        if(turno_1 = false){
                            JOptionPane.showMessageDialog(null,"Encontrado en el turno 1: \n"+encontrado.toString());
                        }
                    }else{
                        JOptionPane.showMessageDialog(null,"El Doctor no se encuentra registrado");
                    }
				}
			break;
			case "6.- Ingresar alfabeticamente":
				turnopcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
    					null, opciones3, opciones3[0]);
				if(turnopcion=="Turno 1") {
					nombre = JOptionPane.showInputDialog ("Nombre del doctor:");

	                especialidad = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
	    					null, opciones2, opciones2[0]);

	                sueldo = Float.parseFloat (JOptionPane.showInputDialog ("Sueldo: "));

	                turno1.insertarAlfabeticamente(new NodoDoctor(new Doctor(nombre,especialidad,sueldo)));
				}else {
					nombre = JOptionPane.showInputDialog ("Nombre del doctor:");
	                
	                especialidad = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
	    					null, opciones2, opciones2[0]);
	                
	             
	                sueldo = Float.parseFloat (JOptionPane.showInputDialog ("Sueldo: "));
	               
	                
	                turno2.insertarAlfabeticamente(new NodoDoctor(new Doctor(nombre,especialidad,sueldo)));
				}
	
				break;
			case "7.- Eliminar en una posicion":
				
				int p = Integer.parseInt (JOptionPane.showInputDialog ("Posicion: "));
				turno1.eliminarEnPosicion(p-1);
			break;
			
			case "9.- Aumentar por posicion":
				
			p = Integer.parseInt (JOptionPane.showInputDialog ("Posicion: "));
			turno1.AumentarSalarioEspecifico(p-1);
			break;

			case "10.- Aumentar por Nombre":
				
			turno1.AumentarSalarioPorNombre(JOptionPane.showInputDialog ("Nombre del doctor:"));

			break;

			case "11.- Aumentar todos los salarios":
				
			turno1.AumentarTodosLosSalarios(Integer.parseInt (JOptionPane.showInputDialog ("Porcentaje a aumentar: ")));
			break;

			case "12.- Doctor que mas gana":
				
			JOptionPane.showMessageDialog(null, turno1.DoctorQueGanaMas().getDoctor().toString());
			break;

			case "13.- Eliminar el ultimo doctor":
				
			turno1.eliminarUltimoNodo();

			break;
			
			case "14.- Eliminar por nombre":
		
			NodoDoctor eliminado = turno1.eliminarPorNombre(JOptionPane.showInputDialog("Ingrese el nombre a buscar: "));
			
			if(eliminado!=null){
				JOptionPane.showMessageDialog(null, "Nodo Eliminado: "+ eliminado.getDoctor().toString());
			}
			break;

			}


			
		}while(tipo != "8.- Terminar");

	}

}

