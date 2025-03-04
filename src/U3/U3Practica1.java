package U3;

import javax.swing.JOptionPane;

public class U3Practica1{
    public static ColaString singular = new ColaString(12);
    public static ColaString plural = new ColaString(12);
    



    public static void main(String[] args){
        	Object[] opciones = { "1.-Introducir frase", "2.-alabras en singular",
				"3.- Mostrar palabras en plural", "4.- Eliminar una palabra en singular", "5.- Eliminar una palabra en plural",
				"6.- Cantidad de palabras", "7.- Palabra plural del final","8.- Terminar" };
		String tipo = "";
		
        do {
			tipo = (String) JOptionPane.showInputDialog(null, "Selecciona una opcion", tipo, JOptionPane.PLAIN_MESSAGE,
					null, opciones, opciones[0]);
			if (tipo == null) {
				tipo = "8.- Terminar";
			}

			switch (tipo) {

			case "1.- Leer una palabra":
                LeerPalabra();
				break;


			case "2.- Mostrar palabras en singular":

             if(!singular.estaVacia()){
                JOptionPane.showMessageDialog(null, singular.toString());
            } else{
                JOptionPane.showMessageDialog(null, "PILA VACIA");    
            }
				break;

			case "3.- Mostrar palabras en plural":

            if(!plural.estaVacia()){
                JOptionPane.showMessageDialog(null, plural.toString());
            } else{
                JOptionPane.showMessageDialog(null, "PILA VACIA");    
            }
				break;


			case "4.- Eliminar una palabra en singular":

            if(!singular.estaVacia()){
                JOptionPane.showMessageDialog(null, "Palabra eliminada: "+singular.eliminar());
            } else{
                JOptionPane.showMessageDialog(null, "NO HAY PALABRA EN SINGULAR PARA ELIMINAR");
            }
				break;


			case "5.- Eliminar una palabra en plural":

            if(!plural.estaVacia()){
                JOptionPane.showMessageDialog(null, "Palabra eliminada: "+plural.eliminar());
            } else{
                JOptionPane.showMessageDialog(null, "NO HAY PALABRA EN SINGULAR PARA ELIMINAR");
            }
				break;

                
			case "6.- Cantidad de palabras":

                JOptionPane.showMessageDialog(null, "Total de palabras en plural: "+(plural.numElementos()));
                JOptionPane.showMessageDialog(null, "\n\nTotal de palabras en singular: "+(singular.numElementos()));
				break;


            case "7.- Palabra plural del final":

                JOptionPane.showMessageDialog(null, "Palabra plural del final: \n\n-"+plural.datoEnFin());
				break;


			case "8.- Terminar":

				break;

			}
		} while (tipo!="8.- Terminar");
    }

    public static void LeerPalabra(){
    	
    	String palabra=JOptionPane .showInputDialog("Ingrese una palabra");
    	if(palabra!=null){
            String UltimaLetra = String.valueOf(palabra.charAt(palabra.length()-1));


            if(UltimaLetra.equalsIgnoreCase("s")) {
			   plural.insertar(palabra);
		   }else {
			singular.insertar(palabra);   
           }
        }else{
            JOptionPane.showMessageDialog(null,"Ingrese una palabra válida");
        }
    	
		
	}
   }
