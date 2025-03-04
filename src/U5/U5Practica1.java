package U5;
/**
 *
 *   Práctica 1 de la Unidad 5
 *   Arbol Binario Ordenado (ABO) de enteros
 **/

import javax.swing.JOptionPane;

public class U5Practica1 {

   public static void main(String args [ ]) {

       // DECLARACION DE VARIABLES

       int opcion, totalOpciones,num;
       
       
       // Crear un ARBOL BINARIO ORDENADO (ABO) vacío SIN nodos
       ArbolBinario tree = new ArbolBinario();
       
        // VARIABLE String  DONDE SE VAN AGREGANDO LAS OPCIONES DEL MENU
        String menu = "         OPCIONES \n";
        menu += "1. Insertar un entero en el ABO \n";
        menu += "2. Recorrido PREorden\n";
        menu += "3. Recorrido INorden \n";
        menu += "4. Recorrido POSTorden \n";
        menu += "5. Salir \n";

        totalOpciones = 5;  // ACTUALIZAR SIEMPRE ESTA VARIABLE PARA AJUSTARSE AL TOTAL DE OPCIONES

        // CICLO ITERATIVO QUE PRESENTA EL MENU DE OPCIONES HASTA QUE EL USUARIO SELECCIONE LA OPCION Salir

        do {
           // SE CAPTURA DEL TECLADO UN ENTERO (NUMERO DE LA OPCION) SEGUN EL MENU PRESENTADO 
           opcion = Integer.parseInt (JOptionPane.showInputDialog (menu));  
        
           switch (opcion){
              case 1:
                     num = Integer.parseInt (JOptionPane.showInputDialog ("Dato a insertar: "));        
                     //insertar el número leído creando un NodoArbolBin ese elemento
                     tree.insertar (new NodoArbolBin (num));
                     break;
              case 2:
                    JOptionPane.showMessageDialog (null, tree.preorden(tree.getRaiz()));
                    break;
              case 3:
                    JOptionPane.showMessageDialog (null, tree.inorden(tree.getRaiz()));
                    break;
              case 4:
                    JOptionPane.showMessageDialog (null, tree.postorden(tree.getRaiz()));
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
