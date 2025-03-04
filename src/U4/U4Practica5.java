package U4;
/**
 *
*   Práctica 1 de la Unidad 5
 *   Lista CIRCULAR de ALUMNOS
 **/
import javax.swing.JOptionPane;

public class U4Practica5 {

   public static void main(String args [ ]) {

       // DECLARACION DE VARIABLES

        int opcion, totalOpciones, edad, numCtrl;
        String nombre;
        float calif[];
       // Crear una lista CIRCULAR de alumnos VACIA
       ListaCircularAlumnos grupoA = new ListaCircularAlumnos();
       
        // VARIABLE String  DONDE SE VAN AGREGANDO LAS OPCIONES DEL MENU
        String menu = "             MENU DE OPCIONES \n";
        menu += "1. Insertar un alumno al inicio \n";
        menu += "2. Insertar un alumno al final \n";
        menu += "3. Mostrar lista de alumnos \n";
        menu += "4. Salir \n";

        totalOpciones = 4;  // ACTUALIZAR SIEMPRE ESTA VARIABLE PARA AJUSTARSE AL TOTAL DE OPCIONES

        // CICLO ITERATIVO QUE PRESENTA EL MENU DE OPCIONES HASTA QUE EL USUARIO SELECCIONE LA OPCION Salir

        do {
           // SE CAPTURA DEL TECLADO UN ENTERO (NUMERO DE LA OPCION) SEGUN EL MENU PRESENTADO 
           opcion = Integer.parseInt (JOptionPane.showInputDialog (menu));  
        
           switch (opcion){
              case 1:
                     nombre = JOptionPane.showInputDialog ("Nombre del alumno:");      
                     //insertar el alumno, creando un Alumno para el nodo
                     float [] c = {90,90,90};
                     Alumno al = new Alumno (nombre, 111,18,c);
                     grupoA.insertaInicio (new NodoAlumno (al));
                     break;
              case 2:
            	  nombre = JOptionPane.showInputDialog ("Nombre del alumno:");      
                  //insertar el alumno, creando un Alumno para el nodo
                  float [] c1= {90,90,90};
                  Alumno al1 = new Alumno (nombre, 111,18,c1);
                  grupoA.insertaFinal(new NodoAlumno(al1));
                     break;       
              case 3:
                     JOptionPane.showMessageDialog (null, grupoA.toString());
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
