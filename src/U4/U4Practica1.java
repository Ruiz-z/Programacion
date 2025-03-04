/**
 *
 *   Práctica 1 de la Unidad 4
 *   Lista de articulos
 **/
package U4;
import javax.swing.JOptionPane;

public class U4Practica1 {

   public static void main(String args [ ]) {

       // DECLARACION DE VARIABLES

       int opcion, totalOpciones, c;
       String d;
       float p;
       
       // Crear una lista de articulos VACIA
       ListaArticulos abarrotes = new ListaArticulos();
       
        // VARIABLE String  DONDE SE VAN AGREGANDO LAS OPCIONES DEL MENU
        String menu = "             MENU DE OPCIONES \n";
        menu += "1. Insertar un articulo al inicio \n";
        menu += "2. Insertar un articulo al final \n";
        menu += "3. Mostrar lista de articulos \n";
        menu += "4. Aumentar precios \n";
        menu += "5. Salir \n";

        totalOpciones = 5;  // ACTUALIZAR SIEMPRE ESTA VARIABLE PARA AJUSTARSE AL TOTAL DE OPCIONES

        // CICLO ITERATIVO QUE PRESENTA EL MENU DE OPCIONES HASTA QUE EL USUARIO SELECCIONE LA OPCION Salir

        do {
           // SE CAPTURA DEL TECLADO UN ENTERO (NUMERO DE LA OPCION) SEGUN EL MENU PRESENTADO 
           opcion = Integer.parseInt (JOptionPane.showInputDialog (menu));  
        
           switch (opcion){
              case 1:
                     d = JOptionPane.showInputDialog ("Descripcion del articulo:");
                     c = Integer.parseInt (JOptionPane.showInputDialog ("Cantidad: "));
                     p = Float.parseFloat (JOptionPane.showInputDialog ("Precio: "));
                     //insertar el articulo, creando un NodoArticulo con los datos leidos
                     abarrotes.insertaInicio (new NodoArticulo (d,c,p));
                     break;
              case 2:
                     d = JOptionPane.showInputDialog ("Descripcion del articulo:");
                     c = Integer.parseInt (JOptionPane.showInputDialog ("Cantidad: "));
                     p = Float.parseFloat (JOptionPane.showInputDialog ("Precio: "));
                     //insertar el articulo, creando un NodoArticulo con los datos leidos
                     abarrotes.insertaFinal (new NodoArticulo (d,c,p));
                     break;       
              case 3:
                     JOptionPane.showMessageDialog (null, abarrotes.toString());
                     break;
             
              case 5:
                       JOptionPane.showMessageDialog (null, "Fin del Programa");
                    break;
              default:
                   JOptionPane.showMessageDialog (null, "Opción NO válida");
               break;
        }  //  FIN DEL SWITCH

      } while (opcion != totalOpciones);   // FIN DEL DO..WHILE


    }  // FIN DEL METODO main
    
}  // FIN DE LA CLASE 
