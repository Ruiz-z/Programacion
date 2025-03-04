package U2;

import javax.swing.JOptionPane;

import utilidades.SalidaFor;


public class U2Practica3 {

	private static final Exception Exception = null;

	public static void main(String[] args) {
		
		Object[] opciones = { "1.- Llegada de un auto", "2.- Mostrar lista de autos",
				"3.- Salida de un auto", "4.- Terminar"};
		String tipo = "";
		do {
			tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);
			if (tipo == null) {
				tipo = "Salir";
			}
			switch (tipo) {
			case "1.- Llegada de un auto":
				LlegadaAuto();
			break;
			case "2.- Mostrar lista de autos":
				MostrarLista();
			break;
			case "3.- Salida de un auto":
				SalidaAuto();
				break;
			case "4.- Terminar":
				break;
			}
		} while (!tipo.equals("4.- Terminar"));
	}
	static String salida="";
	static PilaAutos estacionamiento = new PilaAutos(9);

	public static void LlegadaAuto(){
		if(!estacionamiento.isFull()) {
			String placa=JOptionPane.showInputDialog("Ingrese la placa del auto");
			String owner=JOptionPane.showInputDialog("Ingrese el propietario del auto");
			String marca=JOptionPane.showInputDialog("Ingrese la marca del auto");
			
			try{
			
				for(int i=0;i<estacionamiento.size();i++){
				if(estacionamiento.getP()[i].getPlaca().equals(placa)){
					throw Exception;
				}
			}
				Automovil objAuto= new Automovil(placa,owner,marca);
				estacionamiento.push(objAuto);
				JOptionPane.showMessageDialog(null,"Automovil ingresado correctamente");
			
		}catch(Exception Exception){
			JOptionPane.showMessageDialog(null,"ERROR, La placa ya se encuentra registrada");		

		}
		}else {
			JOptionPane.showMessageDialog(null,"El estacionamiento esta lleno");
		}
	}
	public static void MostrarLista() {
		if(!estacionamiento.isEmpty()) {
			salida+="Datos del estacionamiento:\n";
			salida+=estacionamiento.toString();
			SalidaFor.imprimerConScroll(salida);
		}else {
			JOptionPane.showMessageDialog(null,"Estacionamiento vacio");
		}
		
	}
	public static void SalidaAuto() {
		if (!estacionamiento.isEmpty()) {
            
            String placaABuscar =JOptionPane.showInputDialog("Ingrese la placa del automóvil a sacar: ");
            PilaAutos pilaAuxiliar = new PilaAutos(9);
            boolean encontrado = false;
            while (!estacionamiento.isEmpty()) {
                Automovil automovilActual = estacionamiento.pop();
                if (automovilActual.getPlaca().equalsIgnoreCase(placaABuscar)) {
                    JOptionPane.showMessageDialog(null,"Automóvil que salio del estacionamiento: " +
                automovilActual);
                    encontrado = true;
                    break;
                } else {
                    pilaAuxiliar.push(automovilActual);
                }
            }

            while (!pilaAuxiliar.isEmpty()) {
                estacionamiento.push(pilaAuxiliar.pop());
            }

            if (!encontrado) {
                 JOptionPane.showMessageDialog(null,"Auto no encontrado en el estacionamiento.");
            }
        } else {
        	JOptionPane.showMessageDialog(null,"Estacionamiento vacio, no se puede sacar ningun auto");
        }
		salida=estacionamiento.toString();
	}
}
	


